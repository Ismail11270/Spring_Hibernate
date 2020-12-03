package org.zoobie.spring.lab.jdbc.dao;


import org.springframework.jdbc.core.RowMapper;
import org.zoobie.spring.lab.jdbc.entity.Major;
import org.zoobie.spring.lab.jdbc.sql.SQLQueries;

import java.util.List;

public class MajorDao extends BaseDao<Major> {

    static final RowMapper<Major> mapper = ( ( resultSet, i ) -> {
        var id = resultSet.getInt( 1 );
        var name = resultSet.getString( 2 );
        var instituteId = resultSet.getInt( 3 );
        return new Major( id, name, instituteId );
    } );

    public int createMajor( Major m ) {
        return getJdbcTemplate( ).update(
                "INSERT INTO MAJORS ( MAJOR_NAME, INSTITUTE_ID ) " +
                        "VALUES (?, ?)", m.getName( ), m.getInstituteId( ) );
    }

    public Major getByName( String name ) {
        return getJdbcTemplate( ).queryForObject( SQLQueries.SELECT_WHERE( getTableName( ), "MAJOR_NAME", name ), mapper );
    }

    public List<Major> getByInstituteName( String instituteName ) {
        return getJdbcTemplate( ).query(String.format(
                "SELECT m.* FROM INSTITUTES i " +
                        "JOIN MAJORS m ON i.INSTITUTE_ID = m.INSTITUTE_ID " +
                        "WHERE i.INSTITUTE_NAME = '%s'", instituteName), mapper );
    }

    @Override
    protected String getIdColumn() {
        return Major.COLUMN_ID;
    }

    @Override
    protected String getTableName() {
        return Major.TABLE_NAME;
    }

    @Override
    protected RowMapper<Major> getRowMapper() {
        return mapper;
    }
}
