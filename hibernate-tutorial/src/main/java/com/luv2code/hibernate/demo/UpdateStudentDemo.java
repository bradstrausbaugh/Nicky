package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
				
		try {

			int studentId = 1;
			
			// now, get a new session and start a transaction
			// create session
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on studentId
			System.out.println("\n\nBRAD: Getting a student based on studentId: " + studentId);
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("BRAD: Get complete for myStudent: " + myStudent);
			
			System.out.println("BRAD: Updating myStudent");
			myStudent.setFirstName("Scooby");
			
			// commit transaction
			session.getTransaction().commit(); // commit actually does the update
			                                   // we need not articulate that

			// NEW CODE TO UPDATE EMAIL FOR ALL STUDENTS
			
			// start a new transaction
			// create session
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("BRAD: updating email for all students");
			session.createQuery("update Student set email = 'foo@luv2code.com'")
				.executeUpdate();

			// commit transaction
			session.getTransaction().commit(); // commit actually does the update
			                                   // we need not articulate that

			System.out.println("BRAD: Done!");
			
		}
		finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println("BRAD: tempStudent");
		}
	}

}
