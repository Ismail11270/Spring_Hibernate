package org.zoobie.spring.lab.one.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private int id;
    private char gender;
    private Date date;
    private String name;
    private int teamId;

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