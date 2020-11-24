package org.zoobie.spring.lab.first.two.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "SCHEDULES")
public class Schedule {

    @EmbeddedId
    private ScheduleId id;

    @ManyToOne
    @MapsId("subjectId")
    @JoinColumn(name = "SUBJECT_ID", foreignKey = @ForeignKey(name = "FK_SCHEDULES_SUBJECT_ID"))
    private Subject subject;

    @ManyToOne
    @MapsId("employeeId")
    @JoinColumn(name = "EMPLOYEE_ID", foreignKey = @ForeignKey(name = "FK_SCHEDULES_EMPLOYEE_ID"))
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "ROOM_ID", foreignKey = @ForeignKey(name = "FK_SCHEDULES_ROOM_ID"))
    @Cascade( org.hibernate.annotations.CascadeType.SAVE_UPDATE )
    private ClassRoom classRoom;

    @Column(name = "DAY_OF_WEEK", length = 3)
    private String dayOfWeek;

    @Column(name = "START_TIME")
    private Date startTime;


}
