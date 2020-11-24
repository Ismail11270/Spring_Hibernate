package org.zoobie.spring.lab.first.one;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import org.zoobie.spring.lab.first.one.dao.EmployeeDao;
import org.zoobie.spring.lab.first.one.dao.TeamDao;
import org.zoobie.spring.lab.first.one.entity.Employee;

import java.sql.Date;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DemoApplication.class)
public class Tests {

	@Autowired
	EmployeeDao employeesDao;
	
	@Autowired
	TeamDao teamDao;

	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testEmployeeDao(){
		String name = "Ismoil Atajanov";
		Integer teamId = 1;
		String teamName = "SOFTWARE";

		var startCount = employeesDao.getAll().size();
		var startSoftwareTeamCount = employeesDao.getEmployeesFromTeam( teamName ).size();

		Employee originalEmp = new Employee();
		originalEmp.setGender( 'm' );
		originalEmp.setName( name );
		originalEmp.setTeamId( teamId );
		originalEmp.setDate( Date.valueOf( LocalDate.now() ));

		Assert.assertEquals(1 , employeesDao.createEmployee( originalEmp ));
		Assert.assertEquals( startCount+1, employeesDao.getAll().size() );
		Assert.assertEquals( startSoftwareTeamCount+1, employeesDao.getEmployeesFromTeam( teamName ).size() );

		var newEmp = employeesDao.getByName( name ).get(0);
		Assert.assertEquals( originalEmp.getName(), newEmp.getName() );
		Assert.assertEquals( originalEmp.getGender(), newEmp.getGender() );
		Assert.assertEquals( originalEmp.getTeamId(), newEmp.getTeamId() );
		Assert.assertEquals( originalEmp.getDate(), newEmp.getDate() );

		Assert.assertEquals( 1, employeesDao.deleteById( newEmp.getId() ) );

		int endCount = employeesDao.getCount();
		Assert.assertEquals( startCount, endCount );
	}
}
