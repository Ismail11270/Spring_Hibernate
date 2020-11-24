package org.zoobie.spring.lab.first.two.model;

import lombok.Getter;
import lombok.Setter;
import org.zoobie.spring.lab.converter.BooleanConverter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name="CLASSROOMS")
public class ClassRoom implements Serializable {

    @Id
    @Column(name="ROOM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="ROOM_SIZE")
    private int roomSize;

    @Column(name="SCREEN")
    @Convert(converter = BooleanConverter.class)
    private Boolean screen;

}
