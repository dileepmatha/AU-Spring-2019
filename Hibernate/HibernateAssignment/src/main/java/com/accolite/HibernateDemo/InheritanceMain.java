package com.accolite.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;

import com.accolite.Hibernate.model.CA;
import com.accolite.Hibernate.model.Developer;
import com.accolite.Hibernate.model.Employee;

public class InheritanceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration();
        configuration.configure();
        StandardServiceRegistryBuilder serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory  = configuration.buildSessionFactory(serviceRegistry.build());
        
        Employee emp = new Employee();
        emp.setEmp_name("Dileep");
        CA ca = new CA();
        ca.setType("Articles");
        Developer dev = new Developer();
        dev.setRole("Developer in Accolite");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(emp);
        session.save(ca);
        session.save(dev);
        session.getTransaction().commit();
        session.close();
	}

}
