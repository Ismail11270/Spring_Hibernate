package org.zoobie.spring.lab.one;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.zoobie.spring.lab.one.dao.EmployeeDao;
import org.zoobie.spring.lab.one.dao.InstituteDao;
import org.zoobie.spring.lab.one.dao.MajorDao;
import org.zoobie.spring.lab.one.dao.TeamDao;

import javax.sql.DataSource;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run( DemoApplication.class, args);
	}

	@Bean
	public EmployeeDao employeeDao( DataSource ds){
		EmployeeDao dao = new EmployeeDao();
		dao.setDataSource( ds );
		return dao;
	}

	@Bean
	public InstituteDao instituteDao( DataSource ds){
		InstituteDao dao = new InstituteDao();
		dao.setDataSource( ds );
		return dao;
	}

	@Bean
	public MajorDao majorDao( DataSource ds){
		MajorDao dao = new MajorDao();
		dao.setDataSource( ds );
		return dao;
	}

	@Bean
	public TeamDao teamDao( DataSource ds){
		TeamDao dao = new TeamDao();
		dao.setDataSource( ds );
		return dao;
	}

	@Bean
	public DataSource dataSource() {
		MysqlDataSource	 ds = new MysqlDataSource();
		ds.setUrl("jdbc:mysql://127.0.0.1:6033/university");
		ds.setUser("root");
		ds.setPassword("");
		return ds;
	}


}
