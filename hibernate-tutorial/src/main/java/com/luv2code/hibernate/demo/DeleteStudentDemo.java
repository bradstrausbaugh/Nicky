package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			// NEW CODE TO DELETE THE STUDENT - THERE ARE TWO WAYS TO DO THIS ...
			
			System.out.println("BRAD: Deleting myStudent: " + myStudent);
            // session.delete(myStudent);

			// commit transaction
			// session.getTransaction().commit(); // commit actually does the delete
			                                   // we need not articulate that
			
			// AND NOW THE OTHER WAY ...
			System.out.println("BRAD: Deleting myStudent: Id = 2");
			session.createQuery("delete from Student where Id = 2").executeUpdate();
			
			// commit transaction
			session.getTransaction().commit(); 
			
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
