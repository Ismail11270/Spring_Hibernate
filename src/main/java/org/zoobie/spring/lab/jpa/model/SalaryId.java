package org.zoobie.spring.lab.jpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Setter
@Getter
@Embeddable
public class SalaryId implements Serializable {
    private int employeeId;
    private int projectId;
    @Column(name = "PAY_DATE", nullable = true)
    private Date payDate;

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass( ) != o.getClass( ) ) return false;
        SalaryId salaryId = ( SalaryId ) o;
        return employeeId == salaryId.employeeId &&
                projectId == salaryId.projectId &&
                Objects.equals( payDate, salaryId.payDate );
    }

    @Override
    public int hashCode() {
        return Objects.hash( employeeId, projectId, payDate );
    }
}
