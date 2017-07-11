package edu.metrostate.ics240.p4.gaw886.sim.tests;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;
import edu.metrostate.ics240.p4.gaw886.sim.AirportSimulator;
import edu.metrostate.ics240.p4.gaw886.sim.Flight;
import edu.metrostate.ics240.p4.gaw886.sim.Runway;
import edu.metrostate.ics240.p4.sim.Airport;
import edu.metrostate.ics240.p4.sim.Event;
import edu.metrostate.ics240.p4.sim.Event.EventType;

public class AirportSimTests {

	@Test
	public void testScenarioOne() {
		//Airport.genEventFile("data\\airportSim_01.txt");
		Event[] events;
		AirportSimulator as = new AirportSimulator(10);
		as.processEventFile("data\\airportSim_01.txt");
		events = as.getFlightsHandled();
		assertEquals(1, events.length);
		for(Event event : events) {
			System.out.println(event);
		}
		assertEquals(events[0].getScheduledTime(), events[0].getActualTime());
	}

/*	@Test
	public void testRunway() {
		AirportSimulator as = new AirportSimulator(10);
		as.processEventFile("data\\airportSim_01.txt");
	}*/

}