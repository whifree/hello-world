package com.whz.javaee.proxy;

public class MainTest {
    public static void main(String[] args) {
        MyProxy myProxy = new MyProxy();
        HelloWorld helloWorld = (HelloWorld) myProxy.bind(new HelloWorldImpl());
        helloWorld.sayHelloWorld();
    }
}
