package edu.metrostate.ics240.p3.gaw886.calc;

import java.util.Stack;

public class Entries extends Calculator {

	/**
	 * Creates a new Inputs object that will check for inputs as Double and
	 * choose the appropriate mathematical operation based on the user input
	 * 
	 * @param numStack
	 *            the Stack passed from Calculator()
	 */
	public Entries(Stack<String> numStack) {
		numberStack = numStack;
	}

	/**
	 * Tries to parse the String entry to a Double
	 * 
	 * @param entry
	 *            the provided input as a String
	 * @throws NumberFormatException
	 *             If entry cannot be parsed to Double
	 * @return true if entry can be parsed to Double, otherwise false
	 */
	public boolean isDouble(String entry) {
		try {
			Double.parseDouble(entry);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	/**
	 * Checks the entry for operators [+, -, *, /]
	 * 
	 * @param entry
	 *            the provided input as a String
	 * @throws IllegalArgumentException
	 *             If entry is an illegal or non-operator character
	 * @return true if entry is an operator otherwise false
	 */
	public boolean isOperator(String entry) {
		final String opPattern = "[-+*/]";
		try {
			if (entry.matches(opPattern)) {
				return true;
			} else {
				return false;
			}
		} catch (IllegalArgumentException iae) {
			return false;
		}
	}

	/**
	 * Chooses the correct operation when given two distinct operands, operand 1
	 * and operand 2
	 * 
	 * @param entry
	 *            the provided operator
	 * @throws NullPointerException
	 *             If An operator is passed with no values in the calculator
	 * @throws IllegalArgumentException
	 *             Division by 0
	 * @return the calculated result
	 */
	public void performOperation(String entry) {
		Double result = 0.0;
		Double[] ops = new Double[2];
		if (this.isEmpty()) {
			throw new NullPointerException("The stack has no values");
		} else if (this.size() == 1) {
			ops[0] = this.pop();
			ops[1] = ops[0];
		} else if (this.size() > 1) {
			ops[1] = this.pop();
			ops[0] = this.pop();
		}

		switch (entry) {
		case "+":
			result = ops[0] + ops[1];
			numberStack.push(result.toString());
			break;

		case "-":
			result = ops[0] - ops[1];
			numberStack.push(result.toString());
			break;

		case "*":
			result = ops[0] * ops[1];
			numberStack.push(result.toString());
			break;

		case "/":
			if (ops[1] == 0) {
				throw new IllegalArgumentException("Argument 'divisor' is 0");
			} else {
				result = ops[0] / ops[1];
				numberStack.push(result.toString());
			}
			break;
		}
	}
}