package org.zoobie.spring.lab.first.two.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@Embeddable
public class AllocationId implements Serializable {
    private int employeeId;
    private int projectId;
    private int positionId;

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass( ) != o.getClass( ) ) return false;
        AllocationId that = ( AllocationId ) o;
        return employeeId == that.employeeId &&
                projectId == that.projectId &&
                positionId == that.positionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash( employeeId, projectId, positionId );
    }
}
