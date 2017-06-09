package edu.metrostate.ics240.p2tests.towers;

import edu.metrostate.ics240.p2.towers.Towers;

public class TowersTester {

	public static void main(String[] args) {
		Towers tow1 = new Towers(60);
		Towers tow2 = new Towers();

		System.out.println(tow2.getTopDiameter(1));
		System.out.println(tow2.getTopDiameter(2));
		System.out.println(tow2.move(1, 2));
		System.out.println(tow2.getTopDiameter(1));

		/*System.out.println(tow1.getRingCount(1));
		System.out.println(tow1.getRingCount(1));
		System.out.println(tow1.getRingCount(2));
		System.out.println(tow1.getRingCount(3));

		System.out.println("\n" + tow2.getRingCount(1));
		System.out.println(tow2.getRingCount(2));
		System.out.println(tow2.getRingCount(3));

		System.out.println("\n" + tow1.getTopDiameter(1));
		tow1.move(1, 2);
		tow1.move(1, 2);
		System.out.println(tow1.getTopDiameter(2));
		System.out.println(tow1.getTopDiameter(3));

		System.out.println("\n" + tow2.getTopDiameter(1));
		tow2.move(1, 2);
		tow2.move(1, 2);
		System.out.println(tow2.getTopDiameter(2));
		System.out.println(tow2.getTopDiameter(3));*/

	}

}
