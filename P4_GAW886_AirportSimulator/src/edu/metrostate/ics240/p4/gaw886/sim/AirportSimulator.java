package edu.metrostate.ics240.p4.gaw886.sim;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

import javax.sound.sampled.Line;

import edu.metrostate.ics240.p4.sim.Airport;
import edu.metrostate.ics240.p4.sim.Event;
import edu.metrostate.ics240.p4.sim.Event.EventType;

public class AirportSimulator extends Airport {
	private int numRunways;
	private int arrivalReserveTime;
	private int departureReserveTime;
	private Flight flight;
	private PriorityQueue<Flight> flightQueue = new PriorityQueue<>();
	PriorityQueue<Runway> runways = new PriorityQueue<>();
	Event[] events;

	public AirportSimulator(int numRunways) {
		if (numRunways < 1) {
			throw new IllegalArgumentException("Number of runways must be 1 or greater.");
		} else {
			this.numRunways = numRunways;
			this.arrivalReserveTime = ARR_RESERVE_TIME;
			this.departureReserveTime = DEP_RESERVE_TIME;
		}
		createRunways();
	}

	public AirportSimulator(int numRunways, int arrivalReserveTime, int departureReserveTime) {
		if (numRunways < 1 || arrivalReserveTime < 1 || departureReserveTime < 1) {
			throw new IllegalArgumentException(
					"Number of runways, arrival and departure reserve times must be 1 or greater.");
		} else {
			this.numRunways = numRunways;
			this.arrivalReserveTime = arrivalReserveTime;
			this.departureReserveTime = departureReserveTime;
		}
		createRunways();
	}

	public void processEventFile(String filename) {
		String line;
		String[] flightTuple;
		try (BufferedReader reader = new BufferedReader(new FileReader(filename));) {
			while ((line = reader.readLine()) != null) {
				flightTuple = line.split(DELIM);
				flightQueue.add(new Flight(flightTuple[0], flightTuple[1], flightTuple[2]));
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private void createRunways() {
		for (int i = 0; i < numRunways; i++) {
			runways.add(new Runway());
		}
	}

	public Event[] getFlightsHandled() {
		events = new Event[flightQueue.size()];
		int i = 0;
		for (Flight flight : flightQueue) {
			events[i++] = flight;
		}
		return events;
	}
}