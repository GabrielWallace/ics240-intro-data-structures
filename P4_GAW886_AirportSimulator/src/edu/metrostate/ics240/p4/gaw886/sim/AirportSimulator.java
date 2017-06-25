package edu.metrostate.ics240.p4.gaw886.sim;

import java.io.FileNotFoundException;

import edu.metrostate.ics240.p4.sim.Airport;
import edu.metrostate.ics240.p4.sim.Event;

public class AirportSimulator extends Airport {

	private int numRunways;
	private int arrivalReserveTime;
	private int departureReserveTime;

	public AirportSimulator(int numRunways) {
		if (numRunways < 1) {
			throw new IllegalArgumentException("Number of runways must be 1 or greater.");
		} else {
			this.numRunways = numRunways;
			this.arrivalReserveTime = ARR_RESERVE_TIME;
			this.departureReserveTime = DEP_RESERVE_TIME;
		}
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
	}

	public void processEventFile(String filename) {
		// genEventFile("data/airportSim_01.txt");
		genEventFile("data/airportSim_01.txt", 1.86, 2.56, 100);

	}

	public Event[] getFlightsHandled() {
		// TODO Auto-generated method stub
		return null;
	}
}
