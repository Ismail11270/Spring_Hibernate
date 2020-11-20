package com.example.demo.one.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Major {

    private int id;
    private int name;
    private int instituteId;

    public Major() {}
}
