package com.whz.javaee.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {
    private static final Class<SqlSessionFactoryUtil> LOCK = SqlSessionFactoryUtil.class;
    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession openSqlSession() throws IOException {
        if (null == sqlSessionFactory) {
            createSqlSessionFactory();
        }

        return sqlSessionFactory.openSession();
    }

    private static void createSqlSessionFactory() throws IOException {
        synchronized (LOCK) {
            if (null == sqlSessionFactory) {
                InputStream inputStream = Resources.getResourceAsStream("mybatis-config" +
                        ".xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
        }
    }
}
