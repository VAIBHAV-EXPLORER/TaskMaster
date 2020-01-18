package com.assignment.tasktracker.utility;

import java.util.UUID;

public class ApplicationUtility {
	
	private ApplicationUtility() {
		
	}
	
	public static String getRandomId() {
		return UUID.randomUUID().toString();
	}

}
