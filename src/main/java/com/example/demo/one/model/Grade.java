package com.example.demo.one.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "GRADES")
public class Grade {

    private Student student;

    private Subject subject;
}
