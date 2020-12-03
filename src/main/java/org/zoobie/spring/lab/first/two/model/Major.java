package org.zoobie.spring.lab.first.two.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "MAJORS", uniqueConstraints = {
        @UniqueConstraint( columnNames = "MAJOR_NAME", name = "UK_MAJOR_NAME")
})
public class Major implements Serializable {
    @Id
    @Column(name="MAJOR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="MAJOR_NAME", length = 60, nullable = false)
    private String majorName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="INSTITUTE_ID", foreignKey = @ForeignKey(name = "FK_MAJOR_INSTITUTE_ID"))
    @Cascade( org.hibernate.annotations.CascadeType.SAVE_UPDATE )
    private Institute institute;

    @OneToMany(mappedBy = "major")
    @Cascade( org.hibernate.annotations.CascadeType.SAVE_UPDATE )
    private Set<Student> students = new HashSet<>();
}
