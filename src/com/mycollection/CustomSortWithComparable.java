package com.mycollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee1 implements Comparable<Employee1>{
	float age;
	int salary;
	String name;
	
	public Employee1(float age, int salary, String name) {
		this.age= age;
		this.salary = salary;
		this.name = name;
	}
	
	public String toString() {
		return this.age + ":" + this.salary + ":"+ this.name;
	}

	public int compareTo(Employee1 that) {
		return this.age > that.age ? 1 : -1;
	}
	
	

}
public class CustomSortWithComparable {

	public static void main(String[] args) {
		
		Employee1 e1 = new Employee1(30, 10000, "John");
		Employee1 e2 = new Employee1(28, 20000, "Sierra");
		Employee1 e3 = new Employee1(53, 5800, "Laila");
		Employee1 e4 = new Employee1(36, 29000, "king");

		List<Employee1> employees = new ArrayList<Employee1>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);

		Collections.sort(employees);
		
		System.out.println(employees);
		
	}
}

