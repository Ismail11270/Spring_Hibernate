package org.zoobie.spring.lab.first.two.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "POSITIONS", uniqueConstraints = {
        @UniqueConstraint( columnNames = "POSITION_NAME", name = "UK_POSITION_NAME")
})
public class Position implements Serializable {
    @Id
    @Column(name="POSITION_ID", length = 3)
    private String id;

    @Column(name = "POSITION_NAME", length = 50, nullable = false)
    private String positionName;
}
