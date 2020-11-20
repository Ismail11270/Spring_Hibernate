package com.exaple.demo;

import com.example.demo.one.dao.EmployeeDao;
import com.example.demo.one.dao.TeamDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.one.DemoApplication;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=DemoApplication.class)
public class Tests {

	@Autowired
	EmployeeDao employeesDao;
	
	@Autowired
	TeamDao teamDao;

	//TEAMS EMPLOYEE INSTITUTES MAJOR
	@Test
	public void contextLoads() {
		System.out.println("fefe" );
//		employeesDao.getAll();
		System.out.println( employeesDao.getEmployeeById( 5 ) );
//		System.out.println("Count teams JPA: " + teamDao.getCount());
	}
}
