package edu.metrostate.ics240.p5.gaw886.morse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class EncodeMap {
	Map<Character, String> encoder;
	
	public Map<Character, String> buildMap() {
		String filePath = new String("/data/MorseCode.txt");
		InputStreamReader inputFile = new InputStreamReader(MorseCode.class.getResourceAsStream(filePath));
		HashMap<Character, String> encoder = new HashMap<>();
		String line = new String();
		Character key = null;
		String value = new String();
		String[] keyValueArr = new String[2];

		try (BufferedReader inputReader = new BufferedReader(inputFile);) {
			while ((line = inputReader.readLine()) != null) {
				keyValueArr = line.split("\\t");
				key = keyValueArr[0].charAt(0);
				value = keyValueArr[1];
				encoder.put(key, value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return encoder;
	}
}
