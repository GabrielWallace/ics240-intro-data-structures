package edu.metrostate.edu.ics240.p3.gaw886.tests.calc;

import static org.junit.Assert.*;

import org.junit.Test;
import java.math.BigInteger;
import java.util.Random;

import edu.metrostate.ics240.p3.gaw886.calc.Calculator;

public class CalculatorTests {
	static Random r = new Random();

	@Test
	public void testEnterMethod() {
		Calculator calc = new Calculator();

		// Add 100 random doubles to the stack
		for (int i = 0; i < 100; i++) {
			calc.enter(new BigInteger(10, r).toString());
		}
		assertEquals(100, calc.size());
		calc.clear();
		assertEquals(0, calc.size());

		// Test addition
		calc.enter("10");
		calc.enter("5");
		calc.enter("+");
		assertEquals(15, calc.peek(), 20);

		calc.clear();
		calc.enter("2.5");
		calc.enter("2.25");
		calc.enter("+");
		assertEquals(4.75, calc.peek(), 20);

		// Test subtraction
		calc.clear();
		calc.enter("10");
		calc.enter("5");
		calc.enter("-");
		assertEquals(5, calc.peek(), 20);

		calc.clear();
		calc.enter("2");
		calc.enter("1.25");
		calc.enter("-");
		assertEquals(0.75, calc.peek(), 20);

		// Test multiplication
		calc.clear();
		calc.enter("10");
		calc.enter("5");
		calc.enter("*");
		assertEquals(50, calc.peek(), 20);

		calc.clear();
		calc.enter("2.5");
		calc.enter("2.5");
		calc.enter("*");
		assertEquals(6.25, calc.peek(), 20);

		// Test division
		calc.clear();
		calc.enter("10");
		calc.enter("5");
		calc.enter("/");
		assertEquals(2, calc.peek(), 20);

		calc.clear();
		calc.enter("4.5");
		calc.enter("2.5");
		calc.enter("/");
		assertEquals(1.8, calc.peek(), 20);
	}

	@Test
	public void testEnterMethodSpecialCases() {
		Calculator calc = new Calculator();
		// Test single operator
		calc.clear();
		calc.enter("+");
		assertEquals(0, calc.size());

		// Test single value/single operator addition
		calc.clear();
		calc.enter("5");
		calc.enter("+");
		assertEquals(10, calc.peek(), 2);

		// Test single value/single operator subtraction
		calc.clear();
		calc.enter("5");
		calc.enter("-");
		assertEquals(0, calc.peek(), 2);

		// Test single value/single operator multiplication
		calc.clear();
		calc.enter("5");
		calc.enter("*");
		assertEquals(25, calc.peek(), 2);

		// Test single value/single operator division
		calc.clear();
		calc.enter("5");
		calc.enter("/");
		assertEquals(1, calc.peek(), 2);

		// Test fail on division by 0
		try {// Two distinct values
			calc.enter("2");
			calc.enter("0");
			calc.enter("/");
		} catch (IllegalArgumentException iae) {
			// expected
		}

		try {// One distinct value
			calc.enter("0");
			calc.enter("/");
		} catch (IllegalArgumentException iae) {
			// expected
		}
	}

	@Test
	public void testPeekMethod() {
		Calculator calc = new Calculator();

		calc.enter("256");
		calc.enter("999");

		assertEquals(999, calc.peek(), 2);
	}

	@Test
	public void testPopMethod() {
		Calculator calc = new Calculator();

		calc.enter("256");
		calc.enter("999");

		calc.pop();

		assertEquals(256, calc.peek(), 2);
	}

	@Test
	public void testClearMethod() {
		Calculator calc = new Calculator();

		calc.enter("256");
		calc.enter("999");

		calc.clear();

		assertEquals(0, calc.size());
	}

	@Test
	public void testIsEmptyMethod() {
		Calculator calc = new Calculator();

		assertTrue(calc.isEmpty());

		calc.enter("1");
		calc.enter("2");

		assertFalse(calc.isEmpty());
	}

	@Test
	public void testSizeMethod() {
		Calculator calc = new Calculator();

		calc.enter("1");
		calc.enter("2");
		assertEquals(2, calc.size());

		calc.enter("3");
		calc.enter("4");
		assertEquals(4, calc.size());

		calc.pop();
		assertEquals(3, calc.size());

		calc.clear();
		assertEquals(0, calc.size());
	}
}
