package com.example.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    private String name;
    private Integer age;
}
