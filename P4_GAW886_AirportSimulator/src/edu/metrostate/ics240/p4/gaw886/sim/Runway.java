package edu.metrostate.ics240.p4.gaw886.sim;

public class Runway {
	private Flight flight;

	public Runway() {
		this.flight = null;
	}

	public Boolean isAvailable() {
		if (this.flight == null) {
			return true;
		}
		return false;
	}

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