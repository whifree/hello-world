package com.whz.javaee.spring.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 一般获取applicationContext时需要实现ApplicationContextAware
 * 加载配置文件时需要实现Initializingbean
 *
 */
public class JuiceMaker implements BeanNameAware, BeanFactoryAware,
        ApplicationContextAware, InitializingBean, DisposableBean {

    private Source source;
    private String beverageShop;
    private ApplicationContext applicationContext;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用BeanFactoryAware" +
                "接口的setBeanFactory方法");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用BeanNameAware" +
                "接口的setBeanName方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用BeanFactoryAware" +
                "接口的destroy方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用InitializingBean" +
                "接口的afterPropertiesSet方法");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("【" + this.getClass().getSimpleName() +
                "】调用ApplicationContextAware" +
                "接口的setApplicationContext方法");
        this.applicationContext = applicationContext;
    }

    public void myDestroy() {
        System.out.println("【" + this.getClass().getSimpleName() + "】执行自定义销毁方法");
    }

    public void init() {
        System.out.println("【" + this.getClass().getSimpleName() + "】执行自定义初始化方法");
    }

    public String makeJuice() {
        return "这是一杯由" + beverageShop + "提供的" + source.getSize() + source.getSugar() + source.getFruit();
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public void setBeverageShop(String beverageShop) {
        this.beverageShop = beverageShop;
    }
}
