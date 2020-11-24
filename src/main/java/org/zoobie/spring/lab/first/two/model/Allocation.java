package org.zoobie.spring.lab.first.two.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "ALLOCATIONS")
public class Allocation implements Serializable {

    @EmbeddedId
    private AllocationId id;

    @ManyToOne
    @MapsId("employeeId")
    @JoinColumn(name = "EMPLOYEE_ID", foreignKey = @ForeignKey(name = "FK_ALLOC_EMPLOYEE_ID"), nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Employee employee;

    @ManyToOne
    @MapsId("projectId")
    @JoinColumn(name = "PROJECT_ID", foreignKey = @ForeignKey(name = "FK_ALLOC_PROJECT_ID"), nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Project project;

    @ManyToOne
    @MapsId("positionId")
    @JoinColumn(name = "POSITION_ID", foreignKey = @ForeignKey(name = "FK_ALLOC_POSITION_ID"))
    @Cascade( org.hibernate.annotations.CascadeType.SAVE_UPDATE )
    private Position position;

}
