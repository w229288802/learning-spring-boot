package com.example.domain;

import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class LifeCycle implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware, InitializingBean,DisposableBean {

    @Setter
    private String name;

    @Autowired
    public Windows windows;

    @PostConstruct
    private void postConstruct() throws BeansException{
        System.out.println("5.bean实例化后置调用");
    }

    private void init(){
        System.out.println("7.bean初始化方法");
    }

    private void end(){
        System.out.println("11.bean销毁方法");
    }

    public LifeCycle(){
        System.out.println("1.bean实例化");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("2.bean自定义属性初始化 == " + name);
        System.out.println("2.bean容器属性初始化 == " + windows);
        System.out.println("3.BeanAware接口调用 == setBeanName");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("3.BeanAware接口调用 == setBeanFactory");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("3.BeanAware接口调用 == setBeanClassLoader");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("6.InitializingBean接口方法 == afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("10.DisposableBean接口方法 == destroy");
    }
}
