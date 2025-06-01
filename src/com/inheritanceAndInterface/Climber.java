package com.inheritanceAndInterface;

public class Climber extends Human implements Climbable, WayToMove{

	
	@Override
	public void climb() {
		System.out.println("Climber can climb...");
		
	}

	@Override
	public void move() {
		System.out.println("Climber can hike..");
	}
	
}
