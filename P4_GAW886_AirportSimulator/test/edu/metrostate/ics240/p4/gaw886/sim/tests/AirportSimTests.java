package edu.metrostate.ics240.p4.gaw886.sim.tests;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;
import edu.metrostate.ics240.p4.gaw886.sim.AirportSimulator;
import edu.metrostate.ics240.p4.gaw886.sim.Flight;
import edu.metrostate.ics240.p4.gaw886.sim.Runway;
import edu.metrostate.ics240.p4.sim.Event;
import edu.metrostate.ics240.p4.sim.Event.EventType;

public class AirportSimTests {

	@Test
	public void testScenarioOne() {
		// Airport.genEventFile("data\\airportSim_01.txt");
		Event[] events;
		AirportSimulator as = new AirportSimulator(10);
		as.processEventFile("data\\airportSim_01.txt");
		events = as.getFlightsHandled();
		assertEquals(1, events.length);
		// assertEquals(events[0].getScheduledTime(), events[0].getActualTime());
	}

	@Test
	public void testRunway() {
		Runway runway = new Runway();
		assertEquals(true, runway.checkAvailability());
		Flight flight = new Flight(LocalTime.parse("12:00"), EventType.ARRIVAL, "A100");
		runway.assignFlight(flight );
		assertEquals(false, runway.checkAvailability());
		runway.unassignFlight();
		assertEquals(true, runway.checkAvailability());

	}

}
