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
@Table(name = "SUBJECT_TYPES")
public class SubjectType implements Serializable {
    @Id
    @Column(name="SUB_TYPE_ID", length = 3)
    private String id;

    @Column(name = "SUB_TYPE_NAME", length = 50, nullable = false)
    private String name;
}
