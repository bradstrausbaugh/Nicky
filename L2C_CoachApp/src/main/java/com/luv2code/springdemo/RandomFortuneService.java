package com.luv2code.springdemo;

public class RandomFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return new String[] {"Today is your lucky day",
				             "Have a nice day",
				             "Help a stranger"}[(int)(Math.random()*3)];
	}

}
