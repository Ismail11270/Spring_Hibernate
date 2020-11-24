package org.zoobie.spring.lab.first.one.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
@AllArgsConstructor
public class Employee{
    public static final String TABLE_NAME = "EMPLOYEES";
    private Integer id;
    private Character gender;
    private Date date;
    private String name;
    private Integer teamId;

    public Employee() { }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", gender=" + gender +
                ", date=" + date +
                ", name='" + name + '\'' +
                '}';
    }
}
