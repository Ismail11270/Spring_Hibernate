package org.zoobie.spring.lab.two.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.zoobie.spring.lab.converter.GenderConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "EMPLOYEES")
public class Employee implements Serializable {
    @Id
    @Column(name = "EMPLOYEE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name = "GENDER")
    @Convert(converter = GenderConverter.class)
    private Gender gender;

    @Column(name = "DATE_OF_BIRTH")
    private Date date;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "TEAM_ID", foreignKey = @ForeignKey(name = "FK_EMP_TEAM_ID"))
    private Team team;

}
