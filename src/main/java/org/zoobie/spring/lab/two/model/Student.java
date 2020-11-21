package org.zoobie.spring.lab.two.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.zoobie.spring.lab.converter.GenderConverter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "STUDENTS")
public class Student {
    @Id
    @Column(name = "STUDENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME", length = 30, nullable = false)
    private String name;

    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Column(name = "GENDER")
    @Convert(converter = GenderConverter.class)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "MAJOR_ID", foreignKey = @ForeignKey(name = "FK_STUDENT_MAJOR_ID"))
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Major major;

}
