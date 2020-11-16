package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount() {
		System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
	}

	public boolean addSillyMember() {  // changed from void to boolean return type
		System.out.println(getClass() + ": DOING STUFF: addSillyMember - ADDING A MEMBERSHIP ACCOUNT");
		return true;
	}

}
