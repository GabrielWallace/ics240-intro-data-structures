package edu.metrostate.ics240.p4.gaw886.sim;

import edu.metrostate.ics240.p4.sim.Event.EventType;

public class Runway {
	EventType runwayEvent;
	private boolean isAvailable;
	Flight[] flightArr = new Flight[1];
	
	public Runway() {
		this.isAvailable = true;
		flightArr[0] = null;
	}
	
	public Boolean checkAvailability() {
		if (flightArr[0] == null) {
			isAvailable = true;
		} else {
			isAvailable = false;
		}
		return isAvailable;
	}
	
	public void unassignFlight() {
		flightArr[0] = null;
	}
	
	public void assignFlight(Flight flight) {
		flightArr[0] = flight;
	}
}
