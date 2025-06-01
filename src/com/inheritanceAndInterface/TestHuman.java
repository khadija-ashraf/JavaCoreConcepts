package com.inheritanceAndInterface;

public class TestHuman {

	public void testClimber() {
		Human dummy = new Human(); // human is an abstract concept.
		
		Climber cl = new Climber();
		Developer dev = new Developer();
		
		cl.move();
		dev.move();
		cl.breathe();
		dev.breathe();
		cl.climb();
		dev.code();
	}
	
	public static void main(String a[]) {
		TestHuman ob = new TestHuman();
		
		ob.testClimber();
	}
}
