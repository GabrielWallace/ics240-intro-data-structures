package edu.metrostate.ics240.p3.gaw886.calc;

public class Inputs {

	/**
	 * Creates a new Inputs object that will check for inputs as Double and
	 * choose the appropriate mathematical operation based on the user input.
	 */
	public Inputs() {
	}

	/**
	 * Tries to parse the String entry to a Double
	 * 
	 * @param entry the provided input as a String
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
	 * Chooses the correct operation when given two distinct operands, op1 and
	 * op2
	 * 
	 * @param op1
	 *            operand number one
	 * @param op2
	 *            operand number two
	 * @param operator
	 *            the provided operator
	 * @return the calculated result
	 */
	public Double performOperation(String op1, String op2, String operator) {
		Double result = 0.0;
		switch (operator) {
		case "+":
			result = Double.parseDouble(op1) + Double.parseDouble(op2);
			return result;

		case "-":
			result = Double.parseDouble(op1) - Double.parseDouble(op2);
			return result;

		case "*":
			result = Double.parseDouble(op1) * Double.parseDouble(op2);
			return result;

		case "/":
			if (op2 == "0") {
				throw new IllegalArgumentException("Argument 'divisor' is 0");
			} else {
				result = Double.parseDouble(op1) / Double.parseDouble(op2);
				return result;
			}
		}
		return result;
	}

	/**
	 * Chooses the correct operation when given one distinct operand, op1
	 * 
	 * @param op1
	 *            operand number one
	 * @param operator
	 *            the provided operator
	 * @return the calculated result
	 */
	public Object performOperation(String op1, String operator) {
		Double result = 0.0;
		switch (operator) {
		case "+":
			result = Double.parseDouble(op1) + Double.parseDouble(op1);
			return result;

		case "-":
			result = Double.parseDouble(op1) - Double.parseDouble(op1);
			return result;

		case "*":
			result = Double.parseDouble(op1) * Double.parseDouble(op1);
			return result;

		case "/":
			if (op1 == "0") {
				throw new IllegalArgumentException("Argument 'divisor' is 0");
			} else {
				result = Double.parseDouble(op1) / Double.parseDouble(op1);
				return result;
			}
		}
		return result;
	}
}
