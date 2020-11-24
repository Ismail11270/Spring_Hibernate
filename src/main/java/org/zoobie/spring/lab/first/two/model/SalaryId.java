package org.zoobie.spring.lab.first.two.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Embeddable
public class SalaryId implements Serializable {
    private int employeeId;
    private int projectId;
    @Column(name = "PAY_DATE")
    private Date payDate;
}
