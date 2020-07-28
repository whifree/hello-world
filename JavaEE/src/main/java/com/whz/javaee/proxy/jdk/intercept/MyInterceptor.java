package com.whz.javaee.proxy.jdk.intercept;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyInterceptor implements Interceptor {
    @Override
    public boolean before() {
        System.out.println("前增强");
        return false;
    }

    @Override
    public Object around(Object proxy, Object target, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("前环绕");
        // TODO 可以对参数args做一些处理，如校验
        Object result = method.invoke(target, args);
        // TODO 可以对返回结果做一些处理，如统计
        System.out.println("后环绕");
        return result;
    }

    @Override
    public void after() {
        System.out.println("后增强");
    }
}
