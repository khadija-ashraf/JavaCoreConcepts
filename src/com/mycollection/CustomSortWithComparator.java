package com.mycollection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
	float age;
	int salary;
	String name;
	
	public Employee(float age, int salary, String name) {
		this.age= age;
		this.salary = salary;
		this.name = name;
	}
	
	public float getAge() {
		return age;
	}


	public void setAge(float age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return this.age + ":" + this.salary + ":"+ this.name;
	}
}

public class CustomSortWithComparator {

	public static void main(String[] args) {
		
		Employee e1 = new Employee(30, 10000, "John");
		Employee e2 = new Employee(28, 20000, "Sierra");
		Employee e3 = new Employee(53, 5800, "Laila");
		Employee e4 = new Employee(36, 29000, "king");

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);

		Comparator<Employee> compByAge = (a, b) -> a.age > b.age ? 1 : -1;
		
		Comparator<Employee> compBySalary = new Comparator<Employee>() {
			public int compare(Employee a, Employee b) {
				return a.salary > b.salary ? 1 : -1;
			}
		};
		
		Comparator<Employee> compByName = new Comparator<Employee>() {
			public int compare(Employee a, Employee b) {
				return a.name.length() > b.name.length() ? 1 : -1;
			}
		};
		
		
		Collections.sort(employees, compByAge);
		System.out.println(employees);
		
		Collections.sort(employees, compBySalary);
		System.out.println(employees);
		
		Collections.sort(employees, compByName);
		System.out.println(employees);
		
		
		Comparator<Employee> compSimulteneous = Comparator
					.comparingDouble(Employee::getAge)
					.thenComparingInt(Employee::getSalary)
					.thenComparing(Employee::getName);
					
		Collections.sort(employees, compSimulteneous);		
		System.out.println(employees);
	}

}
