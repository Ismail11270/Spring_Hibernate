package org.zoobie.spring.lab.jdbc.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.zoobie.spring.lab.jdbc.sql.SQLQueries;

import java.util.List;

public abstract class BaseDao<T> extends JdbcDaoSupport{

    public List<T> getAll(  ){
        return getJdbcTemplate().query( SQLQueries.SELECT_ALL( getTableName() ), getRowMapper());
    }

    public T getById(int id){
        return getJdbcTemplate( ).queryForObject( SQLQueries.SELECT_WHERE( getTableName(), getIdColumn(), id ), getRowMapper());
    }

    public int getCount() {
        return getJdbcTemplate( ).queryForObject(  SQLQueries.COUNT_ALL( getTableName() ), Integer.class );
    }

    public int deleteById(Integer id){
        return getJdbcTemplate().update(SQLQueries.DELETE( getTableName(), getIdColumn(), id.toString() ));
    }

    protected abstract String getIdColumn();

    protected abstract String getTableName();

    protected abstract RowMapper<T> getRowMapper();

}
