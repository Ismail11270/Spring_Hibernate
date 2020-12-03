package org.zoobie.spring.lab.jdbc.sql;

public class SQLQueries {
    public static String SELECT_ALL( String table ) {
        return String.format( "SELECT * FROM %s", table );
    }

    public static String SELECT_WHERE( String table, String column, Object val ) {
        return String.format( "SELECT * FROM %s WHERE %s = '%s'", table, column, val );
    }

    public static String DELETE( String table, String column, String val ) {
        return String.format( "DELETE FROM %s WHERE %s = %s", table, column, val );
    }

    public static String COUNT_ALL( String table ) {
        return String.format( "SELECT COUNT(*) FROM %s", table );
    }
}
