package edu.metrostate.ics240.p4.gaw886.sim;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.PriorityQueue;
import java.util.Scanner;
import edu.metrostate.ics240.p4.sim.Airport;
import edu.metrostate.ics240.p4.sim.Event;
import edu.metrostate.ics240.p4.sim.Event.EventType;

public class AirportSimulator extends Airport {
	private int numRunways;
	private int arrivalReserveTime;
	private int departureReserveTime;
	private Flight flight;
	private PriorityQueue<Flight> flightQueue = new PriorityQueue<>();
	Runway[] runways;
	
	public AirportSimulator(int numRunways) {
		if (numRunways < 1) {
			throw new IllegalArgumentException("Number of runways must be 1 or greater.");
		} else {
			this.numRunways = numRunways;
			this.arrivalReserveTime = ARR_RESERVE_TIME;
			this.departureReserveTime = DEP_RESERVE_TIME;
		}
		runways = new Runway[numRunways];
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
		runways = new Runway[numRunways];
	}

	public void processEventFile(String filename) {
		LocalTime scheduledTime = null;
		EventType eventType;
		String flightID;
		try (Scanner scanner = new Scanner(new File(filename)).useDelimiter(DELIM);) {
			while (scanner.hasNext()) {
				scheduledTime = LocalTime.parse(scanner.next());
				eventType = EventType.valueOf(scanner.next());
				flightID = scanner.next();
				flight = new Flight(scheduledTime, eventType, flightID);
				flightQueue.add(flight);
				System.out.println(flightQueue.size()); // Debug line
				System.out.println(flightQueue.peek()); // Debug line
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		createRunways();
	}

	private void createRunways() {
		for (int i = 0; i < numRunways; i++) {
			this.runways[i] = new Runway();
		}
	}
	
	

	public Event[] getFlightsHandled() {
		Event[] events = new Event[flightQueue.size()];
		for (int i = 0; i < flightQueue.size(); i++){
			events[i] = flightQueue.peek();
		}
		return events;
	}
}