package org.zoobie.spring.lab.jdbc.dao;

import org.zoobie.spring.lab.jdbc.entity.Employee;
import org.springframework.jdbc.core.RowMapper;
import org.zoobie.spring.lab.jdbc.sql.SQLQueries;

import java.util.List;

public class EmployeeDao extends BaseDao<Employee> {

    static final RowMapper<Employee> employeeMapper = ( ( resultSet, i ) -> {
        var id = resultSet.getInt( 1 );
        var gender = resultSet.getString( 2 );
        var date = resultSet.getDate( 3 );
        var emp_name = resultSet.getString( 4 );
        var team = resultSet.getInt( 5 );
        return new Employee( id, gender.toCharArray( )[0], date, emp_name, team );
    });

    public List<Employee> getEmployeesFromTeam(String teamName){
        return getJdbcTemplate().query(String.format(
                "SELECT e.* FROM EMPLOYEES e " +
                "JOIN TEAMS t ON e.TEAM_ID = t.TEAM_ID " +
                "WHERE t.TEAM_NAME = '%s'",teamName) , employeeMapper);
    }

    public int createEmployee(Employee e){
        return getJdbcTemplate().update( "INSERT INTO EMPLOYEES ( GENDER, DATE_OF_BIRTH, EMP_NAME, TEAM_ID ) " +
                "VALUES (?, ?, ?, ? )",
                    e.getGender().toString(), e.getDate(), e.getName(), e.getTeamId());
    }

    public List<Employee> getByName(String name){
        return getJdbcTemplate().query( SQLQueries.SELECT_WHERE( getTableName(), "EMP_NAME", name ), employeeMapper);
    }

    @Override
    protected String getIdColumn() {
        return "employee_id";
    }

    @Override
    protected String getTableName() {
        return Employee.TABLE_NAME;
    }

    @Override
    protected RowMapper<Employee> getRowMapper() {
        return employeeMapper;
    }

}
