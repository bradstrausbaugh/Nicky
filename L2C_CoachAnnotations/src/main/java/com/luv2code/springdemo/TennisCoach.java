package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// @Component("thatSillyCoach")
@Component
public class TennisCoach implements Coach {
	
	private FortuneService myFortuneService;
	
	// earlier we used constructor injection ...
	// @Autowired
	// public TennisCoach(FortuneService theFortuneService) {
	//	this.myFortuneService = theFortuneService;
	// }
	
	// but now lets use setter injection ...
	
	public TennisCoach() {
	}
	
	@Autowired
	@Qualifier("happyFortuneService") // for when there are multiple implementations
	public void setMyFortuneService(FortuneService myFortuneService) {
		this.myFortuneService = myFortuneService;
	}



	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}
	
	@Override
	public String getDailyFortune() {
		return myFortuneService.getFortune();
	}

}
