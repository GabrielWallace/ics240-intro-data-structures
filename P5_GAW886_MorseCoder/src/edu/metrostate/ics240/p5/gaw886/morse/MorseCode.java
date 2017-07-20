package edu.metrostate.ics240.p5.gaw886.morse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.metrostate.ics240.p5.morse.TreeNode;

//import edu.metrostate.ics240.p5.morse.TreeNode;

public class MorseCode {

	static {
		encode(new String());
		decode(new String());
	}

	/*
	 * public static void main(String[] args) { getEncodingMap();
	 * System.out.println(encode("Hello, World!")); }
	 */

	public static String encode(String text) {
		String morseEncodedString = null;
		String allowedChars = "[a-zA-Z_0-9 _.,?!():;@]*";
		Pattern p = Pattern.compile(allowedChars);
		Matcher matcher = p.matcher(text);

		if (text == null) {
			throw new NullPointerException("Text cannot be null");
		}

		if (!matcher.matches()) {
			int illegalCharIdx = text.lastIndexOf(allowedChars);
			throw new IllegalArgumentException(String.format("Illegal character encountered: [%s]", text));
		} else {

			Map<Character, String> encodingMap = getEncodingMap();
			encodingMap.put('/', "/");
			StringBuilder morseBuilder = new StringBuilder();
			char[] plainTxtKeys = text.replaceAll("\\s", "/").toUpperCase().toCharArray();
			String morseValue = null;

			for (char plainTxtKey : plainTxtKeys) {
				if (encodingMap.containsKey(plainTxtKey)) {
					morseValue = encodingMap.get(plainTxtKey);
					morseBuilder.append(morseValue + " ");
				}
				morseEncodedString = morseBuilder.toString().replaceAll(" / ", "/").trim();
			}
		}
		return morseEncodedString;
	}

	public static String decode(String code) {
		if (code == null) {
			throw new NullPointerException("Code cannot be null");
		}
		return code;

	}

	public static Map<Character, String> getEncodingMap() {
		String filePath = "/data/MorseCode.txt";
		InputStreamReader inputFile = new InputStreamReader(MorseCode.class.getResourceAsStream(filePath));
		Map<Character, String> encodingMap = new HashMap<>();
		String line = null;
		Character key = null;
		String value = null;
		String[] keyValueArr = new String[2];

		try (BufferedReader inputReader = new BufferedReader(inputFile);) {
			while ((line = inputReader.readLine()) != null) {
				keyValueArr = line.split("\\t");
				key = keyValueArr[0].charAt(0);
				value = keyValueArr[1];
				encodingMap.put(key, value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return encodingMap;
	}

	public static TreeNode<Character> getDecodingTree() {
		return null;
	}
}
