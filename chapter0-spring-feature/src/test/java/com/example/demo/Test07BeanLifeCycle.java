

package com.example.demo;

import com.example.domain.LifeCycle;
import com.example.domain.Windows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Test07BeanLifeCycle.class})
public class Test07BeanLifeCycle implements BeanDefinitionRegistryPostProcessor, BeanPostProcessor, DestructionAwareBeanPostProcessor {


    @Test
    public void contextLoads() {
        System.out.println("=========== Spring启动成功 =================");
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        beanDefinitionRegistry.registerBeanDefinition(LifeCycle.class.getSimpleName(),
                BeanDefinitionBuilder.rootBeanDefinition(LifeCycle.class)
                        .addPropertyValue("name", "name")
                        .setInitMethodName("init")
                        .setDestroyMethodName("end")
                        .getBeanDefinition());
        beanDefinitionRegistry.registerBeanDefinition(Windows.class.getSimpleName(),
                BeanDefinitionBuilder.rootBeanDefinition(Windows.class).getBeanDefinition());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if(LifeCycle.class.isAssignableFrom(o.getClass())){
            System.out.println("4.BeanPostProcess前置处理");
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if(LifeCycle.class.isAssignableFrom(o.getClass())){
            System.out.println("8.BeanPostProcess后置处理");
        }
        return o;
    }

    @Override
    public void postProcessBeforeDestruction(Object o, String s) throws BeansException {
        if(LifeCycle.class.isAssignableFrom(o.getClass())){
            System.out.println("9.Destruction销毁前置处理 == postProcessBeforeDestruction");
        }
    }

    @Override
    public boolean requiresDestruction(Object o) {
        if(LifeCycle.class.isAssignableFrom(o.getClass())){
            return true;
        }
        return false;
    }
}
