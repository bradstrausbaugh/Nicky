package com.luv2code.springdemo;

public class GolfCoach implements Coach {

	FortuneService fortuneService;
	
	GolfCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	@Override
	public String getDailyWorkout() {
		return "Hit a bucket of balls at the practice tee.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
