package pl.polsl.ismoil.atajanov.lab.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Major {
    public static final String TABLE_NAME = "MAJORS";
    public static final String COLUMN_ID = "MAJOR_ID";
    private int id;
    private String name;
    private int instituteId;

    public Major() {}
}
