package com.accolite.HibernateDemo;

import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;

import com.accolite.Hibernate.model.Person;
import com.github.javafaker.Faker;

public class HQLTestMain {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
	        Session session = sessionFactory.openSession();
	        session.beginTransaction();
	     
	     for(int i=1; i<=10; i++) {
	    	 Faker faker = new Faker();
	    	 String name = faker.name().fullName();
	    	 String city = faker.address().city();
	    	 Date now = new Date(); 
	    	 Date future = faker.date().past(200000000, TimeUnit.SECONDS, now);
	    	 Person s = new Person();
	    	 s.setPname(name);
	    	 s.setAddress(city);
	    	 s.setDob(future);
	    	 session.saveOrUpdate(s);
	     }
	     
	     //	Query q = session.getNamedQuery("GT5");
	     //16) Introduction to Criteria API
	     Query q1 = session.createQuery("from Person order by dob");
	     //16)Criteria
	     Criteria cr = session.createCriteria(Person.class);
	     //17) Restrictions
	     cr.add(Restrictions.gt("id",3));
	     cr.addOrder(Order.desc("dob"));
	     //14)Pagination
	     q1.setMaxResults(4);
	     List<Person> results = cr.list();
	     for(Person p: results) {
	    	 System.out.println(p);
	     }
	     session.getTransaction().commit();
	     session.close();
	}

}
