package edu.metrostate.ics240.p4.sim;

import java.time.LocalTime;


public interface Event {
	public enum EventType {
		RUNWAY_AVAIL,
		RUNWAY_ASSIGN,
		ARRIVAL,
		DEPARTURE,
	}
	/**
	 * Returns the actual time of this flight event. Note: the for <code>RUNWAY_AVAL</code> and <code>RUNWAY_ASSIGN</code>event the
	 * scheduled time is the actual time
	 * @return the actualTime
	 */
	LocalTime getActualTime();

	/**
	 * Returns the event type for this flight event
	 * @return the event type for this flight event
	 */
	EventType getEvent();

	/**
	 * Returns the identifier for this flight event
	 * @return the ident the flight or runway identifier for this event
	 */
	String getIdent();

	/**
	 * Returns the schedule time for this event
	 * @return the scheduledTime the scheduled time for this event
	 */
	LocalTime getScheduledTime();

}