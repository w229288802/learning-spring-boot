package com.example.configuration;

import com.example.domain.Department;
import com.example.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Arrays;

@Configuration
@Import(CustomizedConfiguration.class)
public class ImportConfiguration {


}
