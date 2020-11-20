package com.example.demo.one.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "EMPLOYEES")
public class Employee {
    @Id
    @Column(name = "EMPLOYEE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name="GENDER")
    private Character gender;

    @Column(name="DATE_OF_BIRTH")
    private Date date;

    @ManyToOne
    @Cascade( org.hibernate.annotations.CascadeType.SAVE_UPDATE )
    @Column(name="TEAM_ID")
    private Team team;

}
