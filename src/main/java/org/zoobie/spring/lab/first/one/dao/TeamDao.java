package org.zoobie.spring.lab.first.one.dao;

import org.springframework.jdbc.core.RowMapper;
import org.zoobie.spring.lab.first.one.entity.Team;
import org.zoobie.spring.lab.sql.SQLQueries;

import java.util.List;

public class TeamDao extends BaseDao<Team> {

    static RowMapper<Team> mapper = (( resultSet, i ) -> {
        var id = resultSet.getInt( 1 );
        var name = resultSet.getString( 2 );
        var managerId = resultSet.getInt( 3 );
        var instituteId = resultSet.getInt( 4 );
        return new Team( id, name, managerId, instituteId );
    });

    public int createTeam ( Team t ) {
        return getJdbcTemplate( ).update( "INSERT INTO TEAMS ( TEAM_NAME, MANAGER_ID, INSTITUTE_ID ) " +
                "VALUES (?, ?, ?)", t.getName(), t.getManagerId(), t.getInstituteId() );
    }

    public Team getByName(String name){
        return getJdbcTemplate( ).queryForObject( SQLQueries.SELECT_WHERE( getTableName( ), "TEAM_NAME", name ), mapper );
    }

    public List<Team> getByInstituteName( String instituteName ){
        return getJdbcTemplate( ).query(String.format(
                "SELECT t.* FROM INSTITUTES i " +
                        "JOIN TEAMS t ON i.INSTITUTE_ID = t.INSTITUTE_ID " +
                        "WHERE i.INSTITUTE_NAME = '%s'", instituteName), mapper );
    }

    @Override
    protected String getIdColumn() {
        return Team.COLUMN_ID;
    }

    @Override
    protected String getTableName() {
        return Team.TABLE_NAME;
    }

    @Override
    protected RowMapper<Team> getRowMapper() {
        return mapper;
    }
}
