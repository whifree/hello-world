package com.whz.javaee.proxy.jdk.intercept;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface Interceptor {
    /**
     * 前置增强
     *
     * @return true：调用真实方法，false：调用around方法
     */
    boolean before();

    /**
     * 环绕增强
     *
     * @param proxy  代理对象
     * @param target 被代理对象
     * @param method 代理方法
     * @param args   被代理方法参数
     * @return 被代理方法返回
     */
    Object around(Object proxy, Object target, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException;

    /**
     * 后增强
     */
    void after();
}
