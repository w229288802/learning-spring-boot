

package com.example.demo;

import com.example.configuration.ImportDefinationRegistrarConfiguration;
import com.example.configuration.ImportSelectorConfiguration;
import com.example.demo.annotation.ImportDefinationRegistrarAnnotation;
import com.example.domain.Department;
import com.example.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ImportDefinationRegistrarConfiguration.class)
public class Test06ImportDefinationRegistrar {
    @Autowired
    private User user;

    @Test
    public void contextLoads() {
    }
}
