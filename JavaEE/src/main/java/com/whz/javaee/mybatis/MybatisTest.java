package com.whz.javaee.mybatis;

import com.whz.javaee.mybatis.mapper.RoleMapper;
import com.whz.javaee.mybatis.pojo.Role;
import com.whz.javaee.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class MybatisTest {
    public static void main(String[] args) {
        Role role = new Role();
        role.setRoleName("manager");
        role.setDescription("经理");

        try(SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();){
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            roleMapper.insertRole(role);
            // 必须提交
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
