package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		// retrieve bean from spring container
		// remember, we were using the Coach interface but then we changed to the class bc of the set/getters
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		
		CricketCoach anotherCoach = context.getBean("myCricketCoach", CricketCoach.class);
		System.out.println("The two coaches are equal: " + (theCoach == anotherCoach));
		System.out.println("theCoach: " + theCoach);
		System.out.println("anotherCoach: " + anotherCoach);
		
		// close the context
		context.close();

	}

}
