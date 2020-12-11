package pl.polsl.ismoil.atajanov.lab.jpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class GradeId implements Serializable {
    private int studentId;
    private int subjectId;
    @Column(name = "PASS_DATE")
    private Date passDate;

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass( ) != o.getClass( ) ) return false;
        GradeId gradeId = ( GradeId ) o;
        return studentId == gradeId.studentId &&
                subjectId == gradeId.subjectId &&
                Objects.equals( passDate, gradeId.passDate );
    }

    @Override
    public int hashCode() {
        return Objects.hash( studentId, subjectId, passDate );
    }
}
