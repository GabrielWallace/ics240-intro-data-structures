package edu.metrostate.ics240.p4.gaw886.sim.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.metrostate.ics240.p4.gaw886.sim.AirportSimulator;
import edu.metrostate.ics240.p4.gaw886.sim.Flight;
import edu.metrostate.ics240.p4.sim.Event;

public class AirportSimTests {

	@Test
	public void testScenarioOne() {
		//AirportSimulator.genEventFile("data\\airportSim_01.txt");
		Event[] events;
		AirportSimulator as = new AirportSimulator(10);
		as.processEventFile("data/airportSim_01.txt");
		events = as.getFlightsHandled();
		assertEquals(1, events.length);
		assertEquals(events[0].getScheduledTime(), events[0].getActualTime());
	}

}
