package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		// get the application context
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		// fetch a bean
		// Coach coach = context.getBean("thatSillyCoach", Coach.class);
		Coach coach = context.getBean("tennisCoach", Coach.class);
		
		// print output
		System.out.println("Today's workout: " + coach.getDailyWorkout());
		System.out.println("- and the fortune is: " + coach.getDailyFortune());
		
		// tiddy up
		context.close();

	}

}
