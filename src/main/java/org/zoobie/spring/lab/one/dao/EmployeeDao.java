package org.zoobie.spring.lab.one.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.zoobie.spring.lab.one.entity.Employee;
import org.zoobie.spring.lab.one.entity.Team;

import java.util.List;

public class EmployeeDao extends JdbcDaoSupport {
//    public int getCount() {
//        return getJdbcTemplate( ).queryForObject( "SELECT COUNT(*) FROM EMPLOYEES", Integer.class );
//    }

    public static final RowMapper<Employee> employeeMapper = ( ( resultSet, i ) -> {
        var id = resultSet.getInt( 1 );
        var gender = resultSet.getString( 2 );
        var date = resultSet.getDate( 3 );
        var emp_name = resultSet.getString( 4 );
        var team = resultSet.getInt( "TEAM_ID" );
        return new Employee( id, gender.toCharArray( )[0], date, emp_name, team );
    });

    public List<Employee> getAll() {
        return getJdbcTemplate( ).query( "SELECT * FROM EMPLOYEES", employeeMapper);
    }

    public Employee getEmployeeById(int id){
        return getJdbcTemplate( ).queryForObject( "SELECT * FROM EMPLOYEES WHERE employee_id = " + id, employeeMapper);
    }

    public Team getTeamForEmployee(){
//        return getJdbcTemplate().queryForObject("SELECT ");
        return null;
    }


}
