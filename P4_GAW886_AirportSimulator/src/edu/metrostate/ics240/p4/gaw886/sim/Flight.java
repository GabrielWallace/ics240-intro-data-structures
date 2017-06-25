package edu.metrostate.ics240.p4.gaw886.sim;

import java.time.LocalTime;

import edu.metrostate.ics240.p4.sim.Event;

public class Flight implements Event {

	private LocalTime scheduledTime;
	EventType eventType;
	private String flightId;
	private LocalTime actualTime;

	public Flight(LocalTime scheduledTime, EventType eventType, String flightId) {
		this.scheduledTime = scheduledTime;
		this.eventType = eventType;
		this.flightId = flightId;
	}

	@Override
	public LocalTime getActualTime() {
		return this.actualTime;
	}

	@Override
	public String toString() {
		return "Flight [scheduledTime=" + scheduledTime + ", eventType=" + eventType + ", flightId=" + flightId
				+ ", actualTime=" + actualTime + "]";
	}

	@Override
	public EventType getEvent() {
		return this.eventType;
	}

	@Override
	public String getIdent() {
		return this.flightId;
	}

	@Override
	public LocalTime getScheduledTime() {
		return this.scheduledTime;
	}

}
