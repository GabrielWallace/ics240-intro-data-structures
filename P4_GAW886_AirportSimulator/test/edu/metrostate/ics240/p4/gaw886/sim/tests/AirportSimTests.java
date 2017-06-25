package edu.metrostate.ics240.p4.gaw886.sim.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.metrostate.ics240.p4.gaw886.sim.AirportSimulator;

public class AirportSimTests {

	@Test
	public void testConstruction() {
		AirportSimulator as = new AirportSimulator(10);
		// as.processEventFile("data/airportSim_01.txt");
		as.processEventFile("data/airportSim_01.txt");
	}

}
