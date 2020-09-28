package com.luv2code.springdemo;

public class TrackCoach implements Coach{
	
	FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
