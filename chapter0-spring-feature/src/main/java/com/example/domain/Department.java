package com.example.domain;

import lombok.Data;

import java.util.List;

@Data
public class Department {
    List<User> userList;
}
