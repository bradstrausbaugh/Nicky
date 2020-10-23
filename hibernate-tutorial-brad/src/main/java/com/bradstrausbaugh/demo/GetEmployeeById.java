package com.bradstrausbaugh.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bradstrausbaugh.entity.Employee;

public class GetEmployeeById {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Employee.class)
								 .buildSessionFactory();
				
		try {

			int EmployeeId = 2;
			
			// now, get a new session and start a transaction
			// create session
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve employee based on employeeId
			System.out.println("\n\nBRAD: Getting a employee based on employeeId: " + EmployeeId);
			Employee myEmployee = session.get(Employee.class, EmployeeId);
			System.out.println("BRAD: Get complete for myEmployee: " + myEmployee);
			
			// NEW CODE TO DELETE THE EMPLOYEE - THERE ARE TWO WAYS TO DO THIS ...
			
			System.out.println("BRAD: Deleting myEmployee: " + myEmployee);
            // session.delete(myEmployee);
			
			// AND NOW THE OTHER WAY ...
			System.out.println("BRAD: Deleting myEmployee: Id = 3");
			session.createQuery("delete from Employee where Id = 3").executeUpdate();
			
			// commit transaction
			session.getTransaction().commit(); 
			
			System.out.println("BRAD: Done!");
			
		}
		finally {
			factory.close();
		}

	}

	private static void displayEmployees(List<Employee> theEmployees) {
		for (Employee tempEmployee : theEmployees) {
			System.out.println("BRAD: tempEmployee");
		}
	}
	
}
