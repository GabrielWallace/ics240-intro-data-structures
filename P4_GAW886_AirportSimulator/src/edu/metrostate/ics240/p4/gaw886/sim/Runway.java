package edu.metrostate.ics240.p4.gaw886.sim;

import java.time.LocalTime;

public class Runway {
	private Flight flight;
	protected int reserveTime = 0;

	public Runway() {
		this.flight = null;
	}

	public Boolean isAvailable() {
		if (this.flight == null) {
			return true;
		}
		return false;
	}
	
	public void assignFlight(Flight flight, LocalTime simTime) {
		if (this.isAvailable()) {
			this.flight = flight;
			this.reserveTime = flight.runwayResTime;
			flight.setActualTime(simTime);
			System.out.println(flight);
		}
	}

	public void unassignFlight() {
		if (this.isAvailable() == false) {
			this.flight = null;
		}
	}

	public void decreaseResTime() {
		this.reserveTime -= 1;
		
	}
}