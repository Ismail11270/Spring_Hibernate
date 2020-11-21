package org.zoobie.spring.lab.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

/**
 * @author LabHiber
 */

public final class HiberUtil {

    /**
     * choose type of mapping definition XML or annotations
     */
    public enum Mapping {
        /**
         * use xml defined mappings for configuration
         */
        XML,
        /**
         * use annotation defined mappings for confuguration
         */
        ANN;
    }

    /**
     * @param mapping
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory( Mapping mapping) {

        switch (mapping) {
            case XML:
                return (getXMLSessionFactory());
            case ANN:
                return (getANNSessionFactory());
            default:
                return (getXMLSessionFactory());
        }
    }

    public static SessionFactory getXMLSessionFactory() {
        try {
            File mappingDir = new File("src\\xmlMaps");
            Configuration config = new Configuration().configure();

            config.setProperty("hibernate.show_sql", "true");
            config.addDirectory(mappingDir);
            SessionFactory sf = config.buildSessionFactory();

            return (sf);
        } catch (Throwable ex) {

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getANNSessionFactory() {
        try {
            Configuration config = new Configuration().configure();
//            config.setProperty("hibernate.show_sql", "true");
            SessionFactory sf = config.buildSessionFactory();

            return (sf);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

}
