package org.zoobie.spring.lab.two.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "SUBJECT_TYPES", uniqueConstraints = {
        @UniqueConstraint( columnNames = "SUBJECT_TYPE_NAME", name = "UK_SUBJECT_TYPE_NAME")
})
public class SubjectType {
    @Id
    @Column(name="SUBJECT_TYPE_ID", length = 3)
    private String id;

    @Column(name = "SUBJECT_TYPE_NAME", length = 50, nullable = false)
    private String name;
}
