package pl.polsl.ismoil.atajanov.lab.jpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "GRADES")
public class Grade implements Serializable {

    @EmbeddedId
    private GradeId id = new GradeId();

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID", foreignKey = @ForeignKey(name = "FK_GRADES_STUDENT_ID"))
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "SUBJECT_ID", foreignKey = @ForeignKey(name = "FK_GRADES_SUBJECT_ID"))
    @MapsId("subjectId")
    private Subject subject;

    @Column(name = "MEET")
    private int meet;

    @Column(name = "CREDIT_EGZ")
    private Character creditEgz;

    @Column(name = "GRADE")
    private int grade;
}
