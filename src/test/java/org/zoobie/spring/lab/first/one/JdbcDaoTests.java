package org.zoobie.spring.lab.first.one;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.zoobie.spring.lab.first.one.dao.EmployeeDao;
import org.zoobie.spring.lab.first.one.dao.InstituteDao;
import org.zoobie.spring.lab.first.one.dao.MajorDao;
import org.zoobie.spring.lab.first.one.dao.TeamDao;
import org.zoobie.spring.lab.first.one.entity.Employee;
import org.zoobie.spring.lab.first.one.entity.Institute;
import org.zoobie.spring.lab.first.one.entity.Major;
import org.zoobie.spring.lab.first.one.entity.Team;

import java.sql.Date;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DemoApplication.class)
public class JdbcDaoTests {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    TeamDao teamDao;

    @Autowired
    InstituteDao instituteDao;

    @Autowired
    MajorDao majorDao;

    @Test
    public void testEmployeeDao() {
        final String name = "Ismoil Atajanov";
        final Integer teamId = 1;
        final String teamName = "SOFTWARE";

        var startCount = employeeDao.getAll( ).size( );
        var startSoftwareTeamCount = employeeDao.getEmployeesFromTeam( teamName ).size( );

        Employee originalEmp = new Employee( );
        originalEmp.setGender( 'm' );
        originalEmp.setName( name );
        originalEmp.setTeamId( teamId );
        originalEmp.setDate( Date.valueOf( LocalDate.now( ) ) );

        Assert.assertEquals( 1, employeeDao.createEmployee( originalEmp ) );
        Assert.assertEquals( startCount + 1, employeeDao.getAll( ).size( ) );
        Assert.assertEquals( startSoftwareTeamCount + 1, employeeDao.getEmployeesFromTeam( teamName ).size( ) );

        var empByName = employeeDao.getByName( name ).get( 0 );
        assertEqualsEmployee( originalEmp, empByName );

        var empById = employeeDao.getById( empByName.getId( ) );
        assertEqualsEmployee( empByName, empById );

        Assert.assertEquals( 1, employeeDao.deleteById( empByName.getId( ) ) );

        int endCount = employeeDao.getCount( );
        Assert.assertEquals( startCount, endCount );
    }

    private void assertEqualsEmployee( Employee expected, Employee actual ) {
        Assert.assertEquals( expected.getName( ), actual.getName( ) );
        Assert.assertEquals( expected.getGender( ), actual.getGender( ) );
        Assert.assertEquals( expected.getTeamId( ), actual.getTeamId( ) );
        Assert.assertEquals( expected.getDate( ), actual.getDate( ) );
    }

    @Test
    public void testInstituteDao() {
        final String name = "CS AND INFORMATICS";
        final String majorName = "SOFTWARE";

        var startCount = instituteDao.getAll( ).size( );

        Institute originalInst = new Institute( );
        originalInst.setName( name );

        Assert.assertEquals( 1, instituteDao.createInstitute( originalInst ) );
        Assert.assertEquals( startCount + 1, instituteDao.getAll( ).size( ) );

        var instByName = instituteDao.getByName( name ).get( 0 );
        assertEqualsInstitute( originalInst, instByName );

        var instById = instituteDao.getById( instByName.getId( ) );
        assertEqualsInstitute( instByName, instById );

        Assert.assertEquals( 1, instituteDao.deleteById( instByName.getId( ) ) );

        int endCount = instituteDao.getCount( );
        Assert.assertEquals( startCount, endCount );

        Institute byMajor = instituteDao.getByMajorName( majorName );
		Assert.assertEquals(1, byMajor.getId());
    }

    private void assertEqualsInstitute( Institute expected, Institute actual ) {
        Assert.assertEquals( expected.getName( ), actual.getName( ) );
    }

    @Test
    public void testMajorDao() {
		final String name = "PROGRAMMING";
		final String instituteName = "COMPUTER SCIENCE";
		final int instituteId = 1;

		var startCount = majorDao.getAll( ).size( );
		var startCountForInstitute = majorDao.getByInstituteName( instituteName ).size();

		Major major = new Major();
		major.setInstituteId( instituteId );
		major.setName(name);

        Assert.assertEquals(1, majorDao.createMajor( major ));
		Assert.assertEquals( startCount + 1, majorDao.getCount() );
		
		var byName = majorDao.getByName( name );
		System.out.println(byName.getInstituteId() );
		System.out.println( major.getInstituteId() );
		assertEqualsMajor( major, byName );

		var byId = majorDao.getById( byName.getId( ) );
		assertEqualsMajor( byName, byId );

		Assert.assertEquals( startCountForInstitute+1, majorDao.getByInstituteName( instituteName ).size() );
        int id = byName.getId( );
        Assert.assertEquals( 1, majorDao.deleteById( id ) );

		int endCount = majorDao.getCount( );
		Assert.assertEquals( startCount, endCount );
    }

	private void assertEqualsMajor( Major expected, Major actual ) {
		Assert.assertEquals( expected.getName( ), actual.getName( ) );
		Assert.assertEquals( expected.getInstituteId( ), actual.getInstituteId( ) );
	}

    @Test
    public void testTeamDao() {
        final String name = "ORI";
        final String instituteName = "COMPUTER SCIENCE";
        final int instituteId = 1;
        final int managerId = 11;
        var startCount = teamDao.getAll( ).size( );
        var startCountForInstitute = teamDao.getByInstituteName( instituteName ).size();

        Team team = new Team();
        team.setInstituteId( instituteId );
        team.setName( name );
        team.setManagerId( managerId );

        Assert.assertEquals(1, teamDao.createTeam( team ));
        Assert.assertEquals( startCount + 1, teamDao.getCount() );
        Assert.assertEquals( startCountForInstitute+1, teamDao.getByInstituteName( instituteName ).size() );

        var byName = teamDao.getByName( name );
        System.out.println(byName.getInstituteId() );
        System.out.println( team.getInstituteId() );
        assertEqualsTeam( team, byName );

        var byId = teamDao.getById( byName.getId( ) );
        assertEqualsTeam( byName, byId );

        int id = byName.getId( );
        Assert.assertEquals( 1, teamDao.deleteById( id ) );

        int endCount = teamDao.getCount( );
        Assert.assertEquals( startCount, endCount );
    }

    private void assertEqualsTeam( Team expected, Team actual ) {
        Assert.assertEquals( expected.getName( ), actual.getName( ) );
        Assert.assertEquals( expected.getInstituteId( ), actual.getInstituteId( ) );
        Assert.assertEquals( expected.getManagerId( ), actual.getManagerId( ) );
    }

}
