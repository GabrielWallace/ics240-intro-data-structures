package edu.metrostate.ics240.p4.gaw886.sim;

import java.time.LocalTime;
import java.util.Collection;

import edu.metrostate.ics240.p4.sim.Airport;
import edu.metrostate.ics240.p4.sim.Event;

public class Flight implements Event, Comparable<Flight> {
	private LocalTime scheduledTime;
	EventType eventType;
	private String flightId;
	private LocalTime actualTime;

	public Flight(String scheduledTime, String eventType, String flightId) {
		this.scheduledTime = LocalTime.parse(scheduledTime);
		this.eventType = EventType.valueOf(eventType);
		this.flightId = flightId;
		this.actualTime = setActualTime();
	}

	private LocalTime setActualTime() {
		actualTime = scheduledTime;
		return actualTime;
	}

	@Override
	public LocalTime getActualTime() {
		return this.actualTime;
	}

	@Override
	public String toString() {
		return actualTime + "|" + scheduledTime + "|" + eventType + "|" + flightId;
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

	@Override
	public int compareTo(Flight flight) {
		if (flight.eventType == EventType.ARRIVAL) {
			return 1;
		}
		return -1;
	}
}