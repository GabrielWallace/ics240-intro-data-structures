package edu.metrostate.ics240.p4.gaw886.sim;

import java.time.LocalTime;

import edu.metrostate.ics240.p4.sim.Airport;
import edu.metrostate.ics240.p4.sim.Event;

public class Flight implements Event, Comparable<Event.EventType> {
	private LocalTime scheduledTime;
	EventType eventType;
	private String flightId;
	private LocalTime actualTime;

	
	public Flight(LocalTime scheduledTime, EventType eventType, String flightId) {
		this.scheduledTime = scheduledTime;
		this.eventType = eventType;
		this.flightId = flightId;
		this.actualTime = setActualTime();
	}
	
	private LocalTime setActualTime(){
		if (this.eventType == EventType.ARRIVAL) {
			this.actualTime = scheduledTime.plusMinutes(Airport.ARR_RESERVE_TIME);
		} else {
			this.actualTime = scheduledTime.plusMinutes(Airport.DEP_RESERVE_TIME);
		}
		return actualTime;
	}
	
	@Override
	public LocalTime getActualTime() {
		return this.actualTime;
	}

	@Override
	public String toString() {
		return scheduledTime + "|" + eventType + "|" + flightId;
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
	public int compareTo(EventType o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
