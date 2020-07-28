package com.whz.javaee.mybatis.plugin;

import com.whz.javaee.mybatis.pojo.Role;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.Properties;

@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args =
                {Connection.class, Integer.class})
})
public class MyPlugin implements Interceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyPlugin.class);

    private Properties properties = null;

    /**
     * 插件方法，拦截插件的prepare方法
     *
     * @param invocation 入参
     * @return 返回预编译后的prepareStatement
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 获取拦截的statementHandler
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        // 进行绑定，创建MetaObject对象
        MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
        // 分离代理对象链，由于目标对象可以有多个插件，这里需要循环分离出最原始的目标类
        Object object = null;
        while (metaStatementHandler.hasGetter("h")) {
            object = metaStatementHandler.getValue("h");
            metaStatementHandler = SystemMetaObject.forObject(object);
        }

        statementHandler = (StatementHandler) object;

        String sql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
        Role parameterObject = (Role) metaStatementHandler.getValue("delegate.boundSql" +
                ".parameterObject");
        LOGGER.info("执行的SQL：【" + sql + "】");
        LOGGER.info("参数：【" + parameterObject + "】");

        // 继续执行下一个插件
        Object obj = invocation.proceed();
        LOGGER.info("after...");
        return obj;
    }

    /**
     * 生成代理对象
     *
     * @param target 被拦截的对象
     * @return 代理对象
     */
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    /**
     * 设置参数，mybatis初始化（加载mybatis-config.xml时）就会生成插件实例，并调用这个方法
     *
     * @param properties 配置的参数对象
     */
    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
        LOGGER.info("dbType = " + this.properties.get("dbType"));
    }
}
