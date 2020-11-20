package com.example.demo.one.model;

import com.example.demo.one.converter.BooleanConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="CLASSROOMS")
public class ClassRoom {

    @Id
    @Column(name="CLASSROOM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="ROOM_SIZE")
    private Integer roomSize;

    @Column(name="SCREEN")
    @Convert(converter = BooleanConverter.class)
    private Boolean screen;

}
