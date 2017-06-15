package edu.metrostate.ics240.p3.gaw886.calc;

import java.util.EmptyStackException;
import java.util.Stack;

public class Calculator implements StackCalculator {
	protected Stack<String> numberStack;

	/**
	 * Creates a new Calculator object with a new Stack to hold the values
	 */
	public Calculator() {
		numberStack = new Stack<String>();
	}

	@Override
	public void enter(String entry) {

		if (isDouble(entry)) {
			numberStack.push(entry);
		}
		if (isOperator(entry)) {
			performOperation(entry);
		}
	}

	@Override
	public double peek() {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		} else {
			return Double.parseDouble(numberStack.get(this.size() - 1));
		}
	}

	@Override
	public double pop() {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		} else {
			numberStack.remove(numberStack.get(this.size() - 1));
			return Double.parseDouble(numberStack.get(this.size() - 1));
		}
	}

	@Override
	public void clear() {
		for (int i = this.size(); i >= 1; i--) {
			numberStack.remove(i - 1);
		}
	}

	@Override
	public boolean isEmpty() {
		if (this.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("unused")
	@Override
	public int size() {
		int stackSize = 0;
		for (String entry : numberStack) {
			stackSize++;
		}
		return stackSize;
	}


	public boolean isDouble(String entry) {
		try {
			Double.parseDouble(entry);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}


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


	public void performOperation(String operator) {
		Double result = 0.0;
		Double[] ops = new Double[2];
		if (this.isEmpty()) {
			throw new NullPointerException("The stack has no values");
		} else if (this.size() == 1) {
			ops[0] = Double.parseDouble(numberStack.pop());
			ops[1] = ops[0];
		} else if (this.size() > 1) {
			ops[1] = Double.parseDouble(numberStack.pop());
			ops[0] = Double.parseDouble(numberStack.pop());
		}

		switch (operator) {
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