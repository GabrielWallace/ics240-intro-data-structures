package edu.metrostate.ics240.p5.gaw886.morse.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import edu.metrostate.ics240.p5.gaw886.morse.MorseCode;
import edu.metrostate.ics240.p5.gaw886.morse.DecodeTree;
import edu.metrostate.ics240.p5.gaw886.morse.EncodeMap;

public class MorseTester {
	@Test
	public void testBuildTree() {
		try {
			DecodeTree foo = new DecodeTree().buildDecodingTree();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void testEncoding() {
		String line = new String();
		String filePath = new String("/data/MorseCode.txt");
		String[] entry;
		InputStreamReader inputFile = new InputStreamReader(MorseCode.class.getResourceAsStream(filePath));
		try (BufferedReader inputReader = new BufferedReader(inputFile);) {
			while ((line = inputReader.readLine()) != null) {
				entry = new String[2];
				entry = line.split("\\t");
				//System.out.println(MorseCode.encode(entry[0]));
				assertEquals(MorseCode.encode(entry[0]), entry[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(MorseCode.encode("Hello, World!"));
		assertEquals("**** * *-** *-** --- --**--/*-- --- *-* *-** -** -*-*--", MorseCode.encode("Hello, World!"));
	}
	
	@Test
	public void testDecoding() {
		String line = new String();
		String filePath = new String("/data/MorseCode.txt");
		String[] entry;
		InputStreamReader inputFile = new InputStreamReader(MorseCode.class.getResourceAsStream(filePath));
		try (BufferedReader inputReader = new BufferedReader(inputFile);) {
			while ((line = inputReader.readLine()) != null) {
				entry = new String[2];
				entry = line.split("\\t");
				//System.out.println(MorseCode.decode(entry[1]));
				assertEquals(MorseCode.decode(entry[1]), entry[0]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//assertEquals("HELLO, WORLD!", MorseCode.decode("**** * *-** *-** --- --**--"));
	}
}
