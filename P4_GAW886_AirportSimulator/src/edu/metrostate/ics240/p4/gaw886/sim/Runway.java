package edu.metrostate.ics240.p4.gaw886.sim;

public class Runway {
	private Flight flight;

	public Runway() {
		this.flight = null;
	}

	public Boolean getAvailability() {
		if (this.flight == null) {
			return true;
		}
		return false;
	}

	public void assignFlight(Flight flight) {
		if (this.getAvailability() == true) {
			this.flight = flight;
		}
	}

	public void unassignFlight() {
		if (this.getAvailability() == false) {
			this.flight = null;
		}
	}
}