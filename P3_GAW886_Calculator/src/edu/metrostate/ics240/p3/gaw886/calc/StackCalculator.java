package edu.metrostate.ics240.p3.gaw886.calc;

public interface StackCalculator {

	/**
	 * Processes an entry to the calculator. If a double value, the entry is
	 * pushed onto the stack. If an operator (+, -, /,or *), the operands are
	 * popped from the stack and the result of the operation is pushed onto the
	 * stack. Note: the second operand is popped first.
	 * 
	 * @param entry
	 *            entry to the calculator, either a double value or a valid
	 *            operator
	 * 
	 */
	void enter(String entry);

	/**
	 * Looks at the number at the top of this stack without removing it from the
	 * stack.
	 * 
	 * @return top number of this stack
	 * @throws EmptyStackException
	 *             - if this stack is empty
	 */
	double peek();

	/**
	 * Removes the number at the top of this stack and returns that value.
	 * 
	 * @return the number at the the top of this stack
	 * @throws EmptyStackException
	 *             - if this stack is empty
	 */
	double pop();

	/**
	 * Removes all numbers from this stack. The stack will be empty after this
	 * call returns
	 */
	void clear();

	/**
	 * Tests if the number stack of this calculator is empty
	 * 
	 * @return true if and only if this calculator's stack has no values, false
	 *         otherwise
	 */
	boolean isEmpty();

	/**
	 * Returns the number of values in this calculators number stack.
	 * 
	 * @return the number of values in this calculators number stack
	 */
	int size();

	/**
	 * Tries to parse the String entry to a Double
	 * 
	 * @param entry
	 *            The provided input as a String
	 * @throws NumberFormatException
	 *             If entry cannot be parsed to Double
	 * @return true if entry can be parsed to Double, otherwise false
	 */
	boolean isDouble(String entry);

	/**
	 * Checks the entry for operators [+, -, *, /]
	 * 
	 * @param entry
	 *            The provided input as a String
	 * @throws IllegalArgumentException
	 *             If entry is an illegal or non-operator character
	 * @return true if entry is an operator otherwise false
	 */
	boolean isOperator(String entry);

	/**
	 * Chooses the correct operation when given two distinct operands, operand 1
	 * and operand 2
	 * 
	 * @param operator
	 *            The provided operator
	 * @throws NullPointerException
	 *             If An operator is passed with no values in the calculator
	 * @throws IllegalArgumentException
	 *             Division by 0
	 * @return the calculated result
	 */
	void performOperation(String operator);

}