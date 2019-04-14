package com.lcy.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String uuid;
    private String name;
    private String password;
    private String professional;
    private String school;
    private String technical;

}
