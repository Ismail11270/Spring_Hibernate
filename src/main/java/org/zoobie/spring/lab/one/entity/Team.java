package org.zoobie.spring.lab.one.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Team {
	private int id;
	private String name;
	private int managerId;
	private int instituteId;

	public Team(){}
}
