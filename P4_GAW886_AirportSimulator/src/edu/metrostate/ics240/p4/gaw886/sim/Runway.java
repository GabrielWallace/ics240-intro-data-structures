package edu.metrostate.ics240.p4.gaw886.sim;

import edu.metrostate.ics240.p4.sim.Event.EventType;

public class Runway implements Comparable<Runway> {
	EventType runwayEvent;
	Flight flight;
	
	public Runway() {
		runwayEvent = EventType.RUNWAY_AVAIL;
		flight = null;
	}
	
	public Boolean getAvailability() {
		if (this.runwayEvent == EventType.RUNWAY_AVAIL) {
			return true;
		}
		return false;
	}
	
	public void assignFlight(Flight flight) {
		if (this.getAvailability() == true  && this.flight == null) {
			this.flight = flight;
			this.runwayEvent = EventType.RUNWAY_ASSIGN;
		}
	}

	@Override
	public int compareTo(Runway runway) {
		if(this.getAvailability() == true) {
			return 1;
		}
		return -1;
	}
}