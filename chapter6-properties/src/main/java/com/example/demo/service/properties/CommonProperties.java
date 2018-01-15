

package com.example.demo.service.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "app")
public class CommonProperties {
    /**
     * 应用名字
     */
    private String name;
}

