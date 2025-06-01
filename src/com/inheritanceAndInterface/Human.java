package com.inheritanceAndInterface;

public class Human {
	int eyes;
	int ears;
	int legs;
	int head;
	
	public Human() {
		
	}
	public Human(int eyes, int ears, int legs, int head) {
		this.eyes = eyes;
		this.ears = ears;
		this.legs = legs;
		this.head = head;
	}
	
	public void breathe() {
		System.out.println("Human breathing...");
	}
	
	public void eat() {
		System.out.println("Human eating...");
	}
	
	public void sleep() {
		System.out.println("Human sleeping...");
	}
}
