package org.zoobie.spring.lab.first.one.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Institute {
    public static final String TABLE_NAME = "INSTITUTES";
    private int id;
    private String name;
    public Institute(){ }
}
