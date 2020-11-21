package org.zoobie.spring.lab.two;

import org.hibernate.SessionFactory;
import org.zoobie.spring.lab.util.HiberUtil;

public class DemoMain {
//	private final static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory( "project" );

	private static final SessionFactory SESSION_FACTORY = HiberUtil.getSessionFactory(HiberUtil.Mapping.ANN);

	public static void main(String[] args) {


//		EMBuilder.closeFactory( );
	}

}
