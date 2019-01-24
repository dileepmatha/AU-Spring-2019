package com.accolite.HibernateDemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.accolite.Hibernate.model.Address;
import com.accolite.Hibernate.model.Customer;
import com.accolite.Hibernate.model.Student;
import com.accolite.Hibernate.model.UsersCollection;
import com.accolite.Hibernate.model.Vehicle;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory;

public class App 
{
	private static SessionFactory sessionFactory = null;
    private static ServiceRegistry serviceRegistry = null;
     
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
        	
        	 serviceRegistry = new StandardServiceRegistryBuilder()
                     .configure("hibernate.cfg.xml")
                     .build();

             sessionFactory = new Configuration().buildSessionFactory( serviceRegistry );
         }
         return sessionFactory;
    }
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory = App.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		// 1)Saving Object using Hibernate
        Student s = new Student();
        s.setFname("Dileep1");
        s.setLname("Matha");	
        s.setAge(20);	
        
        session.save(s);
        
        // 2) Retrieving Objects using session
        Student p1 = (Student) session.get(Student.class, 1);
        System.out.println(p1);
        
        Address ad = new Address();
        ad.setDno(1123);
        ad.setCity("Hyderabad");
        ad.setStreet("Gachibowli");
        s.setPermanent_address(ad);
        
        Address ad1 = new Address();
        ad1.setDno(123);
        ad1.setCity("Hyderabad");
        ad1.setStreet("Gachibowli2");
        s.setPresent_address(ad1);
        
        Vehicle vh = new Vehicle();
        vh.setName1("Audi");
        vh.setAd(ad);
        
        Vehicle vh1 = new Vehicle();
        vh1.setName1("Audi_1");
        vh1.setAd(ad1);
        
        Vehicle vh2 = new Vehicle();
        vh2.setName1("Audi_2");
        vh2.setAd(ad1);
        
        //6) Saving Collections
        ArrayList<Vehicle> arv = new ArrayList<Vehicle>();
        arv.add(vh);
        arv.add(vh1);
        arv.add(vh2);
        
        Customer cs = new Customer();
        cs.setCs("Accolite");
        cs.setVehicles(arv);
        Set<Address> addr = new HashSet<Address>();
        addr.add(ad);
        addr.add(ad1);
        UsersCollection usaddr = new UsersCollection();
        usaddr.setAddresses(addr);
        session.save(s);
        s.setAge(21);
        session.save(vh);
        //12) Persistent objects
        vh.setName1("BMW");
        session.save(vh1);
        session.save(vh2);
        session.save(cs);
        
        session.getTransaction().commit();
        session.close();
    }
}
