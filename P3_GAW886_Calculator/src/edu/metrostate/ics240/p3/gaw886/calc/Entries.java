package edu.metrostate.ics240.p3.gaw886.calc;

import java.util.Stack;

public class Entries extends Calculator {
	Double[] ops;

	/**
	 * Creates a new Inputs object that will check for inputs as Double and
	 * choose the appropriate mathematical operation based on the user input.
	 */
	public Entries(Stack<String> numStack) {
		numberStack = numStack;
	}

	/**
	 * Tries to parse the String entry to a Double
	 * 
	 * @param entry
	 *            the provided input as a String
	 * @return true if entry can be parsed to Double, otherwise false.
	 */
	public boolean isDouble(String entry) {
		try {
			Double.parseDouble(entry);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * Checks the entry for operators (+ - * /)
	 * 
	 * @param entry
	 *            the provided input as a String
	 * @return true if entry is an operator otherwise false.
	 */
	public boolean isOperator(String entry) {
		String opPattern = "[-+*/]";
		if (entry.matches(opPattern)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Chooses the correct operation when given two distinct operands, op1 and
	 * op2
	 * 
	 * @param op1
	 *            operand number one
	 * @param op2
	 *            operand number two
	 * @param entry
	 *            the provided operator
	 * @return the calculated result
	 */
	public void performOperation(String entry) {
		Double result = 0.0;
		ops = new Double[2];
		if (this.isEmpty()) {
			throw new NullPointerException("The stack has no values");
		} else if (this.size() == 1) {
			ops[0] = this.pop();
			ops[1] = ops[0];
		} else if (numberStack.size() > 1) {
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
