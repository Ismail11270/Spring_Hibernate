package org.zoobie.spring.lab;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.zoobie.spring.lab.jdbc.dao.EmployeeDao;
import org.zoobie.spring.lab.jdbc.dao.InstituteDao;
import org.zoobie.spring.lab.jdbc.dao.MajorDao;
import org.zoobie.spring.lab.jdbc.dao.TeamDao;

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
		ds.setUrl("jdbc:mysql://127.0.0.1:6033/uni");
		ds.setUser("root");
		ds.setPassword("");
		return ds;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jva = new HibernateJpaVendorAdapter();
		jva.setShowSql(true);
		jva.setGenerateDdl(true);
		jva.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return jva;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory( DataSource dataSource,
																		JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setPackagesToScan("org.zoobie.spring.lab.first.one");
		emf.setPersistenceUnitName("unit");
		emf.setDataSource(dataSource);
//		emf.getJpaPropertyMap().put("hibernate.hbm2ddl.auto","create");

		emf.setJpaVendorAdapter(jpaVendorAdapter);
		return emf;
	}

}
