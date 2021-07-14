package com.example.demobiz.model;

import lombok.Data;

@Data
public class Person {
    private boolean isMale;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phone;
}
