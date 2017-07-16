package edu.metrostate.ics240.p4.sim;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Random;

public abstract class Airport {

	public static final double DEPARTURE_PROB = 0.20;
	public static final double ARRIVAL_PROB = 0.15;
	public static final int ARR_RESERVE_TIME = 2;
	public static final int DEP_RESERVE_TIME = 3;
	public static final int SIM_MINUTES = 60;
	public static final long SEED = 20170731201L;
	public static final Random RAND = new Random(SEED);
	public static final String DELIM = "\\|";

	public static void genEventFile(String fileName) {
		genEventFile(fileName, ARRIVAL_PROB, DEPARTURE_PROB, SIM_MINUTES);
	}

	public static void genEventFile(String fileName, double arrivalProbability, double departureProbability,
			int minutes) {
		int arrFlightId = 1;
		int depFlightId = 1;
		try (PrintWriter simFile = new PrintWriter(fileName);) {
			LocalTime time = LocalTime.parse("00:00");

			for (int i = 0; i < minutes; i++) {
				if (RAND.nextDouble() <= arrivalProbability) {
					simFile.printf("%s|%s|%s\n", time.plusMinutes(i), Event.EventType.ARRIVAL,
							String.format("A%03d", arrFlightId++));
				}
				if (RAND.nextDouble() <= departureProbability) {
					simFile.printf("%s|%s|%s\n", time.plusMinutes(i), Event.EventType.DEPARTURE,
							String.format("D%03d", depFlightId++));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads and processes the specified flight event file.
	 * 
	 * @param filename
	 *            path to the flight event file.
	 */
	public abstract void processEventFile(String filename);

	/**
	 * Returns an array of all processed flight arrivals and departures
	 * 
	 * @return array of all flights processed
	 */
	public abstract Event[] getFlightsHandled();

}