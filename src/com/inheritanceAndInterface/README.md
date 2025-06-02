# Java Design Principles: Abstract Class, Interface, Inheritance

In this article, we will understand why Java has Abstract Class, Interface, Inheritance. 

Preface: In this article I've tried to address the curious and fluctuating nature of a human brain while reading a new concept. Every topic mentioned here describes, what is it, why it was needed, how we can use, twist, tweak it. The reference java files are uploaded in the repo.

Please, feel free to reach me if you have any corrections, suggestions, comments, liking, disliking... :)  oh yeah, I assume that you know Java syntax, and have read/known/heard about these mentioned topics before.

## 1. What is Inheritance, Abstract class, Interface? 
### What is Inheritance?
Regarding the object-oriented concepts every noun is an Object. Inheritance simply defined between objects which are involved in a `is-a` relationship. For example, a `Dog` is-a type of `Animal`. As per inheritance, we say the Animal is the parent class and the Dog is a child class. Similary, `Cat` is-an Animal, `Bunny` is-an, `Tiger` is-an Animal, etc.

> Inheritance: one class (child) inherits the states (fields) and behaviors (methods) of another class (parent).

Note:
* No more than one parent is allowed in inheritance - (aviding Diamond Problem-> confilt if multiple parent has same state/behaviours then which one to inherit?)
  
### More Inheritance Relations
* A Payment object related to an Utility Object -> `Utility` is-a `Payment`
* A Payment object related to an Medical Object -> `Medical` is-a `Payment`
* A Computer object related to an Laptop Object -> `Laptop` is-a `Computer`
* A Computer object related to an Desktop Object -> `Desktop` is-a `Computer`

> What is not inheritance? -> A common tip to distinct inheritance from composition relationship
when we can describe the relation between two object as `has-a`.

### Non-Inheritance Relations
* A Car object related to an Engine Object -> `Car` has-an `Engine`
* A House object related to an Bedroom Object -> `House` has-a `Bedroom`
* A House object related to an Pool Object -> `House` has-a `Pool`
* A Pool object related to a Water Object -> `Pool` has-a `Water`
* A Shower object related to a Water Object -> `Shower` has-a `Water`
* A Sea object related to a Water Object -> `Sea` has-a `Water`



### What is an Abstract Class?
Abstract class represents real life objects/concepts those are too generic to be existant, but they still define important behavior.

For Example, a `Shape`, is a generic concept of an object that has boundaries, dimensions, etc. However, when we create a `Shape` object we create a circle, or a rectangle, or a triangle, or a cube, or a cylynder, etc. We should not create a plain `Shape` object, becasue the shape is a concept not a real-life object.

Oh, yeah, do you see, the `Animal` is a generic concept too, so, `Animal` too is an abstract class... :slightly_smiling_face:

> Java has abstract classes to provide a flexible blueprint for future classes that need to share common states (fields) and behaviors (methods), but don’t make sense to instantiate on their own.

Note:
* Can not instantiate an abstract class. -> cause its a concept, not a real-life object.

### What is an Interface?
An Interface defines capabilities, not hierarchy -> what the object can do, not what it is or what it has.
For example: 
* Comparable<T> → makes a class sortable
* Serializable → marks a class as serializable
* Runnable → allows a class to be run in a thread

We add `-able` syllable to any action to represent the capability. 

> An interface is intrigrated to an object to add new capabilities. For example, An `AirPlane` object is `Fly-able`, `Pitch-able`, `Roll-able`, `Yaw-able`. 
> An interface in Java is a blueprint for classes. It defines a contract — a set of method signatures — the methods without bodies only outline the capability. It is upto the implementing object to define how the capability works.

An example scenario that involves, inheritance,and interface. 

:standing_man: A human is an object with states (eyes, ears, legs, head) and behaviours (breath(), eat(), sleep()).

```java
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
		System.out.println("breathing...");
	}
	
	public void eat() {
		System.out.println("eating...");
	}
	
	public void sleep() {
		System.out.println("sleeping...");
	}
}
```
* :climbing_man: A Climber `is-a` Human. It inherits the `breath(), eat(), sleep()` behaviors from the parent object Human.

```java
public class Climber extends Human{
    public Climber() {
		    System.out.println("I'm a climber");
	  }
}

```

* :technologist: A Developer `is-a` Human. It inherits the `breath(), eat(), sleep()` behaviors from the parent object Human.

```java

public class Developer extends Human{
    public Developer() {
		    System.out.println("I'm a developer");
	  }
}

```

```java
public class TestHuman {

	public void testHuman() {
		Human dummy = new Human(); // human is an abstract concept.
		
		Human climber = new Climber();
		climber.breathe();
		
		Human dev = new Developer();
		dev.breathe();
	}
	
	public static void main(String a[]) {
		TestHuman ob = new TestHuman();
		ob.testHuman();
	}
}
```

A climer needs to climb right!, so lets add the `Climbable` capability to the Climber. :star: Remember, `interface` intigrates capabilities. So we create an interface `Climbable`.

```java
public interface Climbable {
	void climb();
}
```
Now the climber implements the `Climbable` capability.

```java 
public class Climber extends Human implements Climbable{
	public Climber() {
		System.out.println("I'm a climber");
	}
	
	@Override
	public void climb() {
		System.out.println("Climber can climb...");
	}
}

```

Similarly A developer needs to build right!, so lets add the `Buildable` capability to the developer.

```java
public interface Buildable {
	void code();
}
```
Now the developer implements the `Buildable` capability.

```java
public class Developer extends Human implements Buildable{

	public Developer() {
		System.out.println("I'm a Developer");
	}
	
	@Override
	public void code() {
		System.out.println("Dev can code...");
	}
}
```

:point_right: Look, now to test the Climber, and developer behavior and capabilities, we need to change the test method.

```java
public class TestHuman {

	public void testHuman() {
		Human dummy = new Human(); // human is an abstract concept.
		
		Climber climber = new Climber(); // Climber is no longer only a human, 
		climber.breathe();		 // he is a climber now
		climber.climb();
		
		System.out.println("-----------");
		Developer dev = new Developer(); // developer is no longer only a human, 
		dev.breathe();			 // he is a developer now
		dev.code();
	}
	
	public static void main(String a[]) {
		TestHuman ob = new TestHuman();
		ob.testHuman();
	}
}

```
:thinking: Now, we want to add a moving capability to the Human, cause you know, every human should be able to move. So we are creating and interface `Movable`

```java
public interface Movable {
	void move();
}
```


----



2. Why Java has Inheritance, Abstract class, Interface?
3. we already have abstract class then why we need interface?
    *  Use an abstract class when there’s a clear parent-child relationship (shared state and behavior).
    *  Use interfaces when classes are unrelated but share behavior, or when you want flexibility, multiple inheritance, or capability tagging.

5. why java does not allow multiple inheritance, but allows multiple interfaces implementations.
6. now can we say interfaces become abstract class with the introduction of default methods in the interfaces?
7. why we need abstract classes
8. what is  constructor logic
9. as we have inheritance why we need abstract classes in java? can we not  use non-abstract classes and interfaces combined to achieve the abstract class functionality?
10. why abstract classes can not be instantiated?
11. example scenario when inheritance appropriate

