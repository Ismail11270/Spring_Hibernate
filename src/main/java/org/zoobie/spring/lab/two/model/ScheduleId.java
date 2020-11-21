package org.zoobie.spring.lab.two.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class ScheduleId implements Serializable {
    private int subjectId;
    private int employeeId;
}
