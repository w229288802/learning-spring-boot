

package com.example.configuration;

import com.example.demo.annotation.ConditionalOnSystemName;
import com.example.domain.Linux;
import com.example.domain.User;
import com.example.domain.Windows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class ConditionalConfiguration {
    @Bean
    @ConditionalOnSystemName("window")
    public Windows createWindows(){
        return new Windows();
    }

    @Bean
    @ConditionalOnSystemName("linux")
    public Linux createLinux(){
        return new Linux();
    }
}
