package com.bradstrausbaugh.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bradstrausbaugh.entity.Employee;;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Employee.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save Java object
			System.out.println("Creating 4 Employee objects.");
			Employee tempEmployee1 = new Employee("John", "Doe", "IBM");
			Employee tempEmployee2 = new Employee("Mary", "Public", "Microsoft");
			Employee tempEmployee3 = new Employee("Bonita", "Applebum", "Intel");
			Employee tempEmployee4 = new Employee("Nicky", "Kayet", "Amazon");

			session.beginTransaction();
			
			System.out.println("Saving the employees...");
			System.out.println(tempEmployee1);
			session.save(tempEmployee1);
			System.out.println(tempEmployee2);
			session.save(tempEmployee2);
			System.out.println(tempEmployee3);
			session.save(tempEmployee3);
			System.out.println(tempEmployee4);
			session.save(tempEmployee4);
			
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}


}
