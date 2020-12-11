package pl.polsl.ismoil.atajanov.lab.jpa.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "SALARIES")
public class Salary implements Serializable {

    @EmbeddedId
    private SalaryId id;

    @ManyToOne
    @MapsId("employeeId")
    @JoinColumn(name = "EMPLOYEE_ID", foreignKey = @ForeignKey(name = "FK_SALARIES_EMPLOYEE_ID"), nullable = false)
    private Employee employee;


    @ManyToOne
    @MapsId("projectId")
    @JoinColumn(name = "PROJECT_ID", foreignKey = @ForeignKey(name = "FK_SALARIES_PROJECT_ID"))
    private Project project;

    @Column(name = "ACCOUNT_DATE")
    private Date accountDate;

//    @Column(name = "PAY_DATE", nullable = false)
//    @MapsId("payDate")
//    private Date payDate;

    @Column(name = "AMOUNT", columnDefinition = "DECIMAL(10,1)", nullable = false)
    private Float amount;

}
