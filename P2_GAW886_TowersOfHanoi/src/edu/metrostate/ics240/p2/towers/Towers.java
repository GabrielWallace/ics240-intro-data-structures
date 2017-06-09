package edu.metrostate.ics240.p2.towers;

import java.util.Stack;

public class Towers {
	private static final int DEFAULT_SIZE = 5;
	private static final int MAX_SIZE = 64;
	private static final int MIN_PEG = 1;
	private static final int MAX_PEG = 3;
	@SuppressWarnings("unchecked")
	private static Stack<Integer>[] tower = new Stack[4];
	private int numOfRings;

	/**
	 * Creates a tower object that can hold up to MAX_SIZE (64) rings. The
	 * Tower() object must have at least 1 ring.
	 */
	public Towers(int n) {
		if (n < 1 || n > MAX_SIZE)
			throw new IllegalArgumentException(
					String.format("Number of rings (%s) cannot be less than 1 or exceed 64 ", n));
		numOfRings = n;
		tower[1] = new Stack<Integer>();
		tower[2] = new Stack<Integer>();
		tower[3] = new Stack<Integer>();
		for (int i = numOfRings; i >= 1; i--)
			tower[1].push(i);
	}

	/**
	 * Creates a tower object that can hold up to DEFAULT_SIZE (5) rings.
	 */
	public Towers() {
		numOfRings = DEFAULT_SIZE;
		tower[1] = new Stack<Integer>();
		tower[2] = new Stack<Integer>();
		tower[3] = new Stack<Integer>();
		for (int i = numOfRings; i >= 1; i--)
			tower[1].push(i);
	}

	/**
	 * pegCheck() checks the peg passed as a parameter to ensure it is within
	 * the exclusive range of 1-3. Any number less than 1 or greater than 3 will
	 * throw IllegalArgumentException.
	 * 
	 * @param pegNumber
	 *            The given peg either 1, 2 or 3.
	 * 
	 * @throws IllegalArgumentException
	 *             If pegNumber is less than 1 or greater than 3.
	 */
	private static void pegCheck(int pegNumber) {
		if (pegNumber < MIN_PEG || pegNumber > MAX_PEG)
			throw new IllegalArgumentException(
					String.format("Peg number (%s) cannot be less than 1 or exceed 3 ", pegNumber));
	}

	/**
	 * Returns the number of rings on a given peg.
	 * 
	 * @param pegNumber
	 *            The given peg either 1, 2 or 3.
	 * @return tower[pegNumber].size()
	 */
	public int getRingCount(int pegNumber) {
		pegCheck(pegNumber);
		if (tower[pegNumber].isEmpty()) {
			return 0;
		} else
			return tower[pegNumber].size();
	}

	/**
	 * Returns the diameter of the topmost ring of a given peg.
	 * 
	 * @param pegNumber
	 *            The given peg either 1, 2 or 3.
	 * @return tower[pegNumber].get(tower[pegNumber].size() - 1)
	 */
	public int getTopDiameter(int pegNumber) {
		pegCheck(pegNumber);
		if (getRingCount(pegNumber) > 0) {
			return tower[pegNumber].get(tower[pegNumber].size() - 1);
		}
		return 0;
	}

	/**
	 * The move method checks the following preconditions:
	 * <p>
	 * <ul>
	 * <li>if endPeg is not equal to startPeg.</li>
	 * <li>if getRingCount(startPeg) is greater than 0 (zero)</li>
	 * <li>if getRingCount(endPeg) is equal to 0 (zero) or
	 * getTopDiameter(startPeg) is greater than getTopDiameter(endPeg).</li>
	 * </ul>
	 * </P>
	 * If all the above preconditions are true the ring is moved from startPeg
	 * to endPeg otherwise it returns false.
	 * 
	 * @param startPeg
	 *            The peg containing the ring to be moved
	 * @param endPeg
	 *            The peg that will receive the ring from startPeg
	 * @return true if preconditions are met, otherwise false
	 */
	public boolean move(int startPeg, int endPeg) {
		pegCheck(startPeg);
		pegCheck(endPeg);

		if (endPeg != startPeg) {
			if (getRingCount(startPeg) > 0) {
				if (getRingCount(endPeg) == 0 || getTopDiameter(startPeg) < getTopDiameter(endPeg)) {
					int topRing = tower[startPeg].pop();
					tower[endPeg].push(topRing);
					return true;
				}

			}
		}
		return false;
	}
}