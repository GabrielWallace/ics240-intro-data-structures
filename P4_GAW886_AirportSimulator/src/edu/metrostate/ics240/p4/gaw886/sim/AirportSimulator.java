package edu.metrostate.ics240.p4.gaw886.sim;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import edu.metrostate.ics240.p4.sim.Airport;
import edu.metrostate.ics240.p4.sim.Event;

public class AirportSimulator extends Airport {
	private int numRunways;
	private int arrivalReserveTime;
	private int departureReserveTime;
	private Flight flight;
	private PriorityQueue<Flight> flightQueue = new PriorityQueue<>();
	private Runway[] runways;
	private Event[] events;

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
				flightQueue.offer(new Flight(flightTuple[0], flightTuple[1], flightTuple[2]));
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		handleFlights();
	}

	private void handleFlights() {
		
	}

	private void createRunways() {
		runways = new Runway[numRunways];
		for (int i = 0; i < numRunways; i++) {
			runways[i] = new Runway();
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
	
	public void testMethod() {
		for (int i = flightQueue.size(); i > 0; i--) {
			System.out.println(flightQueue.poll());
		}
	}
}