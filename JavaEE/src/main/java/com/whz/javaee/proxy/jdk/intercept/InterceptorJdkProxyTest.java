package com.whz.javaee.proxy.jdk.intercept;

import com.whz.javaee.proxy.HelloWorld;
import com.whz.javaee.proxy.HelloWorldImpl;

public class InterceptorJdkProxyTest {
    public static void main(String[] args) {
        HelloWorld proxy = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(),
                "com.whz.javaee.proxy.jdk.intercept.MyInterceptor");
        proxy.sayHelloWorld();
    }
}
