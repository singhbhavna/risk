package com.psas.common;

import javax.management.relation.Role;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.psas.pojo.Bank1;

import com.psas.pojo.Users;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
	private static Session session;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
    	    configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
    	    configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/reqman");
    	    configuration.setProperty("hibernate.connection.username", "postgres");
    	    configuration.setProperty("hibernate.connection.password", "123");
    	    configuration.setProperty("hibernate.show_sql", "true");
    	   configuration.setProperty("hibernate.default_schema", "reqman");
    	   configuration.setProperty("hibernate.hbm2ddl.auto", "update");
    	    
    	   configuration.addAnnotatedClass(Role.class);
    	   configuration.addAnnotatedClass(Bank1.class);
    	  configuration.addAnnotatedClass(Users.class);
            ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
             
            // builds a session factory from the service registry
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);           
        }
         
        return sessionFactory;
    }
    
    public static Session getSession()
    {
    	session = HibernateUtil.getSessionFactory() != null 
    			? HibernateUtil.getSessionFactory().openSession() : null;
    			
		return session;
    }
    
    


}