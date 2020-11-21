package org.zoobie.spring.lab.two.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "PROJECTS")
public class Project implements Serializable {
    @Id
    @Column(name="PROJECT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "PROJECT_NAME", length = 50, nullable = false)
    private String name;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "MANAGER_ID", foreignKey = @ForeignKey(name = "FK_PROJECTS_EMPLOYEE_ID"))
    @Cascade( org.hibernate.annotations.CascadeType.SAVE_UPDATE )
    private Employee manager;

    @ManyToOne
    @JoinColumn(name = "PARENT_PROJECT_ID", foreignKey = @ForeignKey(name = "FK_PROJECT_PARENT_PROJECT_ID"))
    @Cascade( org.hibernate.annotations.CascadeType.SAVE_UPDATE )
    private Project parentProject;

}
