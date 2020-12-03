package org.zoobie.spring.lab.jpa.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "SUBJECT_TYPES")
public class SubjectType {
    @Id
    @Column(name="SUB_TYPE_ID", length = 3)
    private String id;

    @Column(name = "SUB_TYPE_NAME", length = 50, nullable = false)
    private String name;
}
