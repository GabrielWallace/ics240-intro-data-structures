package edu.metrostate.ics240.p5.gaw886.morse.tests;

import static org.junit.Assert.fail;

import java.net.PasswordAuthentication;

import org.junit.Test;

import edu.metrostate.ics240.p5.gaw886.morse.MorseCode;


public class MorseTester {
	@Test
	public void testEncoding() {
		MorseCode.encode("Hello, World.");
		MorseCode.encode("Hello, World?");
		MorseCode.encode("Hello, World!");
		MorseCode.encode("Hello, World(");
		MorseCode.encode("Hello, World)");
		MorseCode.encode("Hello, World:");
		MorseCode.encode("Hello, World;");
		MorseCode.encode("Hello, World@");
		MorseCode.encode("Hello, World$");
		
		try {
			MorseCode.encode("Hello, World$"); // illegal value
			fail("Expected exception");
		} catch (IllegalArgumentException iae) {
			// expected
		}
	}
	
	@Test
	public void testMultiThreads() {
		
	}
}
