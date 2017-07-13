package edu.metrostate.ics240.p4.gaw886.sim;

import edu.metrostate.ics240.p4.sim.Airport;

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
	
	public void setReserveTime(int reserveTime) {
		this.reserveTime = reserveTime;
	}
	
	public void 

	public void assignFlight(Flight flight) {
		if (this.isAvailable() == true) {
			this.flight = flight;
		}
	}

	public void unassignFlight() {
		if (this.isAvailable() == false) {
			this.flight = null;
		}
	}
}