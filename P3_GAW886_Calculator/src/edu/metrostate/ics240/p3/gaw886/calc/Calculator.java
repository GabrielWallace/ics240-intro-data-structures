package edu.metrostate.ics240.p3.gaw886.calc;

import java.util.EmptyStackException;
import java.util.Stack;

public class Calculator implements StackCalculator {
	Stack<String> numberStack;
	String topValue;

	/**
	 * Creates a new Calculator object with a new Stack to hold the values
	 */
	public Calculator() {
		numberStack = new Stack<String>();
	}

	@Override
	public void enter(String entry) {
		Inputs input = new Inputs();
		String op1 = null;
		String op2 = null;
		if (input.isDouble(entry)) {
			numberStack.push(entry);
		} else if (entry == "+" || entry == "-" || entry == "*" || entry == "/") {
			if (this.isEmpty()) {
				numberStack.clear();
			}

			else if (this.size() <= 1) {
				op1 = numberStack.pop();
				numberStack.push(input.performOperation(op1, entry).toString());
			}

			else if (this.size() > 1) {
				op2 = numberStack.pop();
				op1 = numberStack.pop();
				numberStack.push(input.performOperation(op1, op2, entry).toString());
			}
		}
	}

	@Override
	public double peek() {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		} else {
			topValue = numberStack.get(this.size() - 1);
			return Double.parseDouble(topValue);
		}
	}

	@Override
	public double pop() {
		topValue = numberStack.get(this.size() - 1);
		if (this.isEmpty()) {
			throw new EmptyStackException();
		} else {
			numberStack.remove(topValue);
			return Double.parseDouble(topValue);
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
		for (String number : numberStack) {
			stackSize++;
		}
		return stackSize;
	}
}
