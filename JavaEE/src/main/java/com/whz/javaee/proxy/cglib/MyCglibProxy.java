package com.whz.javaee.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyCglibProxy implements MethodInterceptor {

    /**
     * 生成CGLB代理对象
     *
     * @param cls 被代理类
     * @return 代理对象
     */
    public Object getProxy(Class cls) {
        // 创建增强子
        Enhancer enhancer = new Enhancer();
        // 设置增强类型
        enhancer.setSuperclass(cls);
        // 定义代理类为当前对象，当前对象需要实现MethodInterceptor的方法
        enhancer.setCallback(this);
        // 生成并返回代理对象
        return enhancer.create();
    }

    /**
     * 代理方法
     *
     * @param proxy       代理对象
     * @param method      方法
     * @param args        被代理方法的参数
     * @param methodProxy 方法代理
     * @return 代理返回
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("前增强");
        // cglib反射调用真实对象的方法
        Object o = methodProxy.invokeSuper(proxy, args);
        System.out.println("后增强");
        return o;
    }
}
