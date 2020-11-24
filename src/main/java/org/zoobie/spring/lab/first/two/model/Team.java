package org.zoobie.spring.lab.first.two.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "TEAMS", uniqueConstraints = {
        @UniqueConstraint( columnNames = "TEAM_NAME", name = "UK_TEAM_NAME")
})
public class Team {
    @Id
    @Column(name="TEAM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TEAM_NAME", length = 50, nullable = false)
    private String teamName;

    @ManyToOne
    @JoinColumn(name="MANAGER_ID", foreignKey = @ForeignKey(name = "FK_TEAM_MANAGER_ID"))
    private Employee manager;

    @ManyToOne
    @JoinColumn(name="INSTITUTE_ID", foreignKey = @ForeignKey(name = "FK_TEAM_INST_ID"))
    private Institute institute;

}
