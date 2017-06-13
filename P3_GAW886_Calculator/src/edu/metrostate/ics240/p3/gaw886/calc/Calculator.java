package edu.metrostate.ics240.p3.gaw886.calc;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.experimental.theories.Theories;

public class Calculator implements StackCalculator {
	protected Stack<String> numberStack;
	private String topValue = null;

	/**
	 * Creates a new Calculator object with a new Stack to hold the values
	 */
	public Calculator() {
		numberStack = new Stack<String>();
	}

	@Override
	public void enter(String entry) {
		Entry input = new Entry(numberStack);

		if (input.isDouble(entry)) {
			numberStack.push(entry);
		}

		if (input.isOperator(entry)) {
			input.performOperation(entry);
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
		if (this.isEmpty()) {
			throw new EmptyStackException();
		} else {
			topValue = numberStack.get(this.size() - 1);
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
		for (String entry : numberStack) {
			stackSize++;
		}
		return stackSize;
	}
}