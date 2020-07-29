package com.whz.javaee.spring.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("spring-config.xml");
        JuiceMaker juiceMaker = (JuiceMaker) classPathXmlApplicationContext.getBean(
                "juiceMaker");
        System.out.println(juiceMaker.makeJuice());
        System.out.println(juiceMaker.getApplicationContext());
        classPathXmlApplicationContext.close();
    }
}
