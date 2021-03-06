package com.luv2code.hibernate.demo;

import java.util.List;

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
			
			// then, start a transaction and save the new Student instance
			session.beginTransaction();
			
			// query the students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(theStudents);
			
			// query all student whose lastName is "Doe"...
			System.out.println("\n\nDisplay Student with lastName of 'Doe");
			theStudents = session.createQuery("from Student s where s.lastName = 'Doe'").getResultList();
				// note: we use s.lastName, the property not the getter
			displayStudents(theStudents);
			
			// query all student whose lastName is "Doe" and firstName is "Daffy" ...
			System.out.println("\n\nDisplay Students with lastName of 'Doe' and firstName is 'Daffy'...");
			theStudents = session
					.createQuery("from Student s where s.lastName = 'Doe' or s.firstName = 'Daffy'")
					.getResultList();
				// note: we use properties not getters
			displayStudents(theStudents);
			
			// query all student whose email ends with 'luv2code.com'...
			System.out.println("\n\nDisplay Students whose email ends with 'luv2code.com'");
			theStudents = session.createQuery("from Student s where s.email LIKE '%luv2code.com'").getResultList();
				// note: we use properties not getters
			displayStudents(theStudents);

			// commit transaction
			session.getTransaction().commit(); // don't forget to commit
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
