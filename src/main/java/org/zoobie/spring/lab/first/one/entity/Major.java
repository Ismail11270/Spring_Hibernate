package org.zoobie.spring.lab.first.one.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Major {
    public static final String TABLE_NAME = "MAJORS";
    private int id;
    private int name;
    private int instituteId;

    public Major() {}
}
