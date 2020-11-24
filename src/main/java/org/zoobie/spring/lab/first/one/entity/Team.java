package org.zoobie.spring.lab.first.one.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Team {
	public static final String TABLE_NAME = "TEAMS";
	private int id;
	private String name;
	private int managerId;
	private int instituteId;

	public Team(){}
}
