package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	
	FortuneService fortuneService;
	
	BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice 30 minutes in the batting cage.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
