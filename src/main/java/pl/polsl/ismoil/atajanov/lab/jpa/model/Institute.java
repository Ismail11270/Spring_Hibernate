package pl.polsl.ismoil.atajanov.lab.jpa.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "INSTITUTES", uniqueConstraints = {
        @UniqueConstraint(columnNames = "INSTITUTE_NAME", name = "UK_INSTITUTE_NAME")
})
public class Institute implements Serializable {
    @Id
    @Column(name = "INSTITUTE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "INSTITUTE_NAME", length = 60, nullable = false)
    private String instituteName;

}
