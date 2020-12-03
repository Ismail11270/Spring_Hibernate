package org.zoobie.spring.lab.jdbc.dao;

import org.springframework.jdbc.core.RowMapper;
import org.zoobie.spring.lab.jdbc.entity.Institute;
import org.zoobie.spring.lab.jdbc.sql.SQLQueries;

import java.util.List;

public class InstituteDao extends BaseDao<Institute> {

    static final RowMapper<Institute> mapper = ( ( resultSet, i ) -> {
        var id = resultSet.getInt( 1 );
        var name = resultSet.getString( 2 );
        return new Institute( id, name );
    } );

    public int createInstitute( Institute i ) {
        return getJdbcTemplate( ).update( "INSERT INTO INSTITUTES ( INSTITUTE_NAME ) " +
                "VALUES (?)", i.getName( ) );
    }

    public List<Institute> getByName( String name ) {
        return getJdbcTemplate( ).query( SQLQueries.SELECT_WHERE( getTableName( ), "INSTITUTE_NAME", name ), mapper );
    }

    public Institute getByMajorName( String majorName ) {
        return getJdbcTemplate( ).queryForObject(String.format(
                "SELECT i.* FROM INSTITUTES i " +
                        "JOIN MAJORS m ON i.INSTITUTE_ID = m.INSTITUTE_ID " +
                        "WHERE m.MAJOR_NAME = '%s'", majorName), mapper );
    }

    @Override
    protected String getIdColumn() {
        return "institute_id";
    }

    @Override
    protected String getTableName() {
        return Institute.TABLE_NAME;
    }

    @Override
    protected RowMapper<Institute> getRowMapper() {
        return mapper;
    }
}
