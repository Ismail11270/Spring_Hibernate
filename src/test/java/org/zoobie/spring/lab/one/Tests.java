package org.zoobie.spring.lab.one;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import org.zoobie.spring.lab.one.DemoApplication;
import org.zoobie.spring.lab.one.dao.EmployeeDao;
import org.zoobie.spring.lab.one.dao.TeamDao;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= DemoApplication.class)
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
