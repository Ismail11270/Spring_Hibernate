package org.zoobie.spring.lab.two.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Setter
@Getter
@Embeddable
public class AllocationId implements Serializable {
    private int employeeId;
    private int projectId;
}
