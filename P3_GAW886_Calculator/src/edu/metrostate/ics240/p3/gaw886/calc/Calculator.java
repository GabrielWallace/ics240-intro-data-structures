package edu.metrostate.ics240.p3.gaw886.calc;

import java.util.EmptyStackException;
import java.util.Stack;

public class Calculator implements StackCalculator {
	private Stack<Double> numberStack;

	/**
	 * Creates a new Calculator object with a new Stack to hold the values
	 */
	public Calculator() {
		numberStack = new Stack<Double>();
	}

	@Override
	public void enter(String entry) {
		if (entry.matches("[-+*/]")) {
			performOperation(entry);
		} else {
			numberStack.push(Double.parseDouble(entry));
		}
	}

	@Override
	public double peek() {
		return numberStack.peek();
	}

	@Override
	public double pop() {
		return numberStack.pop();
	}

	@Override
	public void clear() {
		numberStack.clear();
	}

	@Override
	public boolean isEmpty() {
		return numberStack.isEmpty();
	}

	@Override
	public int size() {
		return numberStack.size();
	}

	/*
	 * Chooses the correct operation (+, -, /,or *), when given two distinct operands, ops[0]
	 * and ops[1]
	 * 
	 * @param operator The provided operator
	 * 
	 * @throws EmptyStackException If An operator is passed with no values in
	 * the calculator
	 * 
	 * 
	 * @return the calculated result
	 */
	private void performOperation(String operator) {
		Double result = 0.0;
		Double[] ops = new Double[2];
		if (this.isEmpty()) {
			throw new EmptyStackException();
		} else if (this.size() == 1) {
			ops[0] = this.pop();
			ops[1] = ops[0];
		} else if (this.size() > 1) {
			ops[1] = this.pop();
			ops[0] = this.pop();
		}

		switch (operator) {
		case "+":
			result = ops[0] + ops[1];
			numberStack.push(result);
			break;

		case "-":
			result = ops[0] - ops[1];
			numberStack.push(result);
			break;

		case "*":
			result = ops[0] * ops[1];
			numberStack.push(result);
			break;

		case "/":
			result = ops[0] / ops[1];
			numberStack.push(result);
			break;
		}
	}
}