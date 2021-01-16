package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
	
	private FortuneService myFortuneService;

	@Autowired
	@Qualifier("happyFortuneService")
	public void setMyFortuneService(FortuneService myFortuneService) {
		this.myFortuneService = myFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice batting";
	}

	@Override
	public String getDailyFortune() {
		return myFortuneService.getFortune();
	}

}
