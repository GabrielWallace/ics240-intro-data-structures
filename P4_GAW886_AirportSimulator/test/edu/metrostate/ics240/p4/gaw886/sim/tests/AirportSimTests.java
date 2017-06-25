package edu.metrostate.ics240.p4.gaw886.sim.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.metrostate.ics240.p4.gaw886.sim.AirportSimulator;
import edu.metrostate.ics240.p4.sim.Event;

public class AirportSimTests {

	@Test
	public void testScenarioOne() {
		AirportSimulator as = new AirportSimulator(10);
		Event[] events = as.getFlightsHandled();
		as.processEventFile("data/airportSim_01.txt");
		assertEquals(1, events.length);
		assertEquals(events[0].getScheduledTime(), events[0].getActualTime());
	}

}
