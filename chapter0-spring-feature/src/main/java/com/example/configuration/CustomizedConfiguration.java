package com.example.configuration;

import com.example.domain.Department;
import com.example.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class CustomizedConfiguration {

    @Bean
    public Department createDepartment(User user){
        Department department = new Department();
        department.setUserList(Arrays.asList(user));
        return department;
    }

    @Bean
    public User createUser(){
        User user = new User();
        user.setName("张三");
        user.setAge(20);
        return user;
    }

}
