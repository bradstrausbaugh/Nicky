package com.bradstrausbaugh.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bradstrausbaugh.entity.Employee;

public class QueryByCompany {

	public static void main(String[] args) {
				
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Employee.class)
								 .buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		// then, start a transaction and save the new Student instance
		session.beginTransaction();
		
		// query all employees by company ...
		System.out.println("\n\nDisplay employees working at Chewy");
		List<Employee> theEmployees = session
				.createQuery("from Employee e where e.company = 'Chewy'")
				.getResultList();
			// note: we use properties not getters
		
		displayEmployees(theEmployees);

	}
	
	private static void displayEmployees(List<Employee> theEmployees) {
		for (Employee tempEmployee : theEmployees) {
			System.out.println(tempEmployee);
		}
	}


}
