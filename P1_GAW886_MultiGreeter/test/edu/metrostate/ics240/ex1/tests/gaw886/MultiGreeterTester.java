package edu.metrostate.ics240.ex1.tests.gaw886;

import java.util.Arrays;

import edu.metrostate.ics240.p1.gaw886.MultiGreeter;

public class MultiGreeterTester {

	public static void main(String[] args) {
		MultiGreeter mg = new MultiGreeter();
		MultiGreeter mg1 = new MultiGreeter(1);
		
		System.out.println("mg Max Gretings: " + mg.getMaxGreetings());
		System.out.println("mg Add Greeting: Bonjour " + mg.addGreeting("Bonjour"));
		System.out.println("mg Add Greeting: Vilkommen " + mg.addGreeting("Vilkommen"));
		System.out.println("mg Add Greeting: Hola " + mg.addGreeting("Hola"));
		System.out.println("mg Add Greeting: Ciao " + mg.addGreeting("Ciao"));
		System.out.println("mg Number of Greetings: " + mg.getNumGreetings());
		System.out.println(mg.getGreetings());
		System.out.println(mg.greet());
		System.out.println(mg.greet("Gabriel"));
		
		System.out.println("\n");
		
		System.out.println("mg1 Add Greeting: Bonjour " + mg1.addGreeting("Bonjour"));
		System.out.println("mg1 Add Greeting: Vilkommen " + mg1.addGreeting("Vilkommen"));
		System.out.println("mg1 Add Greeting: Hola " + mg1.addGreeting("Hola"));
		System.out.println("mg1 Add Greeting: Ciao " + mg1.addGreeting("Ciao"));
		System.out.println("mg1 Max Gretings: " + mg1.getMaxGreetings());
		System.out.println("mg1 Number of Greetings: " + mg1.getNumGreetings());
		mg1.getGreetings();
		System.out.println(mg1.greet());
		System.out.println(mg1.greet("Gabriel"));
		
	}

}
