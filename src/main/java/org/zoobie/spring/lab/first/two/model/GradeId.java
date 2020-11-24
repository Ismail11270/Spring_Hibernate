package org.zoobie.spring.lab.first.two.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Getter
@Setter
public class GradeId implements Serializable {
    private int studentId;
    private int subjectId;
    @Column(name = "PASS_DATE")
    private Date passDate;
}
