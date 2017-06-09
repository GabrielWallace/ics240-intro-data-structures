package edu.metrostate.ics240.p1.gaw886;

import java.util.Random;

public class MultiGreeter {
	private static final int MAX_NUM_GREETINGS = 12;
	private static final String DEFAULT_GREETING = "Hello";
	private static final String DEFAULT_NAME = "World";
	private String[] greetingList;
	private int greetingCount;
	private int maxGreets = MAX_NUM_GREETINGS;
	int randomIdx;
	String randomGreeting;

	/**
	 * Creates a MultiGreeter object that can hold up to 12 greetings
	 */
	public MultiGreeter() {
		greetingList = new String[MAX_NUM_GREETINGS];
		greetingCount = 0;
	}

	/**
	 * Creates a MultiGreeter object that can hold up to maxGreetings
	 * maxGreetings must be positive or 0
	 * 
	 * @param maxGreetings
	 *            Maximum number of greetings
	 * 
	 * @throws IllegalArgumentException
	 *             if maxGreetings is less than 0
	 */
	public MultiGreeter(int maxGreetings) {
		maxGreets = maxGreetings;
		if (maxGreetings >= 0) {
			greetingList = new String[maxGreetings];
			greetingCount = 0;
		} else {
			throw new IllegalArgumentException(String.format("Negative value detected MultiGreeter(%s)", maxGreetings));
		}
	}

	/**
	 * Returns the maximum number of greetings the MultiGreeter can hold
	 * 
	 * @return greetingList.length int
	 */
	public int getMaxGreetings() {
		return greetingList.length;
	}

	/**
	 * Returns the number of greetings added to the MultiGreeter object
	 * 
	 * @return greetingCount int
	 */
	public int getNumGreetings() {
		return greetingCount;
	}

	/**
	 * Adds a greeting to the MultiGreeter object and increments greetingCount
	 * as long as the number of greetings is less than maxGreetings
	 * 
	 * @param greeting
	 *            the greeting to be added to MultiGreeter object
	 * 
	 * @return false if no greeting added, or true if greeting is added
	 */
	public Boolean addGreeting(String greeting) {
		if (greetingCount == maxGreets) {
			return false;
		} else {
			greetingList[greetingCount] = greeting;
			greetingCount++;
			return true;
		}
	}

	/**
	 * Returns a String array containing all of the greetings added to the
	 * MultiGreeter object
	 * 
	 * @return greetings String[]
	 */
	public String[] getGreetings() {
		String[] greetings = new String[greetingCount];
		for (int i = 0; i < greetingCount; i++) {
			greetings[i] = greetingList[i];
		}
		return greetings;
	}

	/**
	 * Returns a greeting combined with a provided name
	 * 
	 * @param name
	 *            a provided name
	 * 
	 * @return DEFAULT_GREETING + name if greetingCount = 0 or randomGreeting +
	 *         name if greetingCount > 0 string
	 */
	public String greet(String name) {
		if (greetingCount == 0) {
			return String.format("%s, %s!", DEFAULT_GREETING, name);
		} else {
			randomIdx = new Random().nextInt(greetingCount);
			randomGreeting = greetingList[randomIdx];
			return String.format("%s, %s!", randomGreeting, name);
		}
	}

	/**
	 * Returns a greeting combined with DEFAULT_NAME
	 * 
	 * @return DEFAULT_GREETING + DEFAULT_NAME if greetingCount = 0 or
	 *         randomGreeting + DEFAULT_NAME if greetingCount > 0 string
	 */
	public String greet() {
		if (greetingCount == 0) {
			return String.format("%s, %s!", DEFAULT_GREETING, DEFAULT_NAME);
		} else {
			randomIdx = new Random().nextInt(greetingCount);
			randomGreeting = greetingList[randomIdx];
			return String.format("%s, %s!", randomGreeting, DEFAULT_NAME);
		}
	}
}
