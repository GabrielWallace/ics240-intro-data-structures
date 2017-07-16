package edu.metrostate.ics240.p4.gaw886.sim;

import java.time.LocalTime;
import edu.metrostate.ics240.p4.sim.Event;

public class Flight implements Event, Comparable<Flight> {
	private LocalTime scheduledTime;
	private EventType eventType;
	private String flightId;
	private int eventFileLineNum = 0;
	private LocalTime actualTime;
	protected int runwayResTime = 0;

	public Flight(String scheduledTime, String eventType, String flightId, int eventFileOrder) {
		this.actualTime = null;
		this.scheduledTime = LocalTime.parse(scheduledTime);
		this.eventType = EventType.valueOf(eventType);
		this.flightId = flightId;getClass();
		this.eventFileLineNum = eventFileOrder;
	}

	public LocalTime setActualTime(LocalTime actualTime) {
		this.actualTime = actualTime;
		return actualTime;
	}
	
	public int getRunwayResTime() {
		return runwayResTime;
	}
	
	public void setRunwayResTime(AirportSimulator as) {
		if (this.eventType == EventType.ARRIVAL) {
			this.runwayResTime = as.arrivalReserveTime;
		} else {
			this.runwayResTime = as.departureReserveTime;
		}
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
	public int compareTo(Flight other) {
		int answer = 1;
		if (this.eventType == EventType.ARRIVAL && other.eventType == EventType.DEPARTURE) {
			answer = -1;
		} else if (this.eventType == EventType.DEPARTURE && other.eventType == EventType.ARRIVAL) {
			answer = 1;
		} else if (this == other) {
			answer = this.getScheduledTime().compareTo(other.getScheduledTime());
			if (answer == 0) {
				if (this.eventFileLineNum < other.eventFileLineNum) {
					answer = -1;
				}
			}
		}
		return answer;
	}
}