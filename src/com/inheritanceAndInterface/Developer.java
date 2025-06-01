package com.inheritanceAndInterface;

public class Developer extends Human implements Buildable, WayToMove{

	@Override
	public void code() {
		System.out.println("Dev can code...");

		
	}

	@Override
	public void move() {
		System.out.println("Dev can drive...");
		
	}

	
}
