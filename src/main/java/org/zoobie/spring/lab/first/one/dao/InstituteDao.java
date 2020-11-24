package org.zoobie.spring.lab.first.one.dao;

import org.springframework.jdbc.core.RowMapper;
import org.zoobie.spring.lab.first.one.entity.Institute;

public class InstituteDao extends BaseDao<Institute> {

    private static final RowMapper<Institute> mapper = ( ( resultSet, i ) -> {
        var id = resultSet.getInt( 1 );
        var name = resultSet.getString( 2 );
        return new Institute( id, name );
    } );

    public void createInstitute( Institute i ) {
        getJdbcTemplate( ).update( "INSERT INTO INSTITUTES ( INSTITUTE_NAME ) " +
                        "VALUES (?)", i.getName( ) );
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
