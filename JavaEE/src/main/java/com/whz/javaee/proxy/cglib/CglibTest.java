package com.whz.javaee.proxy.cglib;

public class CglibTest {
    public static void main(String[] args) {
        MyCglibProxy myCglibProxy = new MyCglibProxy();
        HelloWorld2 helloWorld2 = (HelloWorld2) myCglibProxy.getProxy(HelloWorld2.class);
        helloWorld2.sayHelloWorld();
    }
}
