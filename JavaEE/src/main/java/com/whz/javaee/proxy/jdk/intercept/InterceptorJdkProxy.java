package com.whz.javaee.proxy.jdk.intercept;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterceptorJdkProxy implements InvocationHandler {

    private Object target;
    private String interceptorClass;

    private InterceptorJdkProxy(Object target, String interceptorClass) {
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    /**
     * 创建代理对象
     *
     * @param target           被代理对象
     * @param interceptorClass 拦截器的全限定名
     * @return 代理对象
     */
    public static Object bind(Object target, String interceptorClass) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new InterceptorJdkProxy(target,
                        interceptorClass));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (interceptorClass == null) {
            // 没有设置拦截器，直接调用真实方法
            return method.invoke(target, args);
        }

        Object result = null;

        // 通过反射生成拦截器
        Interceptor interceptor =
                (Interceptor) Class.forName(interceptorClass).newInstance();

        // 调用拦截器方法
        if (interceptor.before()) {
            result = method.invoke(target, args);
        } else {
            interceptor.around(proxy, target, method, args);
        }

        interceptor.after();

        return result;
    }
}
