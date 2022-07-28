package com.prac.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserProfile {
    private String id;
    private String name;
    private String phone;
    private String address;
}
