package com.luv2code.hibernate.demp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save a new Student object
			
			// first, instantiate the POJO - Java 101
			System.out.println("Creating a new Student object.");
			Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");
			
			// then, start a transaction and save the new Student instance
			session.beginTransaction();
			System.out.println("Saving the student...");
			System.out.println(tempStudent);  // note: Id wb 0 at this point
			session.save(tempStudent);
			session.getTransaction().commit(); // don't forget to commit
			
			// find out the student's id (primary key) - no longer null, having been saved
			System.out.println("Saved Student - generated Id: " + tempStudent.getId());
			
			// get a new session and start a transaction
			// - you always use transactions in Hibernate, even for reads
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the Id: primary key
			System.out.println("\nGetting student with Id: " + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
				// myStudent wb null if this Id was not in the table
			System.out.println("myStudent: " + myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
