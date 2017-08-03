package edu.metrostate.ics240.p5.gaw886.morse;

import java.util.Map;

import edu.metrostate.ics240.p5.gaw886.morse.DecodeTree.MorseNode;
import edu.metrostate.ics240.p5.morse.TreeNode;

public class MorseCode {
	
	private static Map<Character, String> encoder;
	private static MorseNode decoder;
	
	static {
		encoder = new EncodeMap().buildMap();
		new DecodeTree().buildDecodingTree(encoder);
		decoder = DecodeTree.getRoot();
	}

	/**
	 * Takes a string of plain text English and encodes it into a string of Morse Code using a <code>StringBuffer()</code>
	 * to build the string
	 * @param <code>text</code> the text to be encoded to Morse Code
	 * @return <code>morseBuilder</code> using <code>StringBuffer()</code> return the new string of Morse Code
	 */
	public static String encode(String text) {
		if (text == null) {
			throw new NullPointerException("Text cannot be null");
		} else {
			Map<Character, String> encoder = getEncodingMap();
			StringBuffer morseBuilder = new StringBuffer();
			char[] plainTxtKeys = new char[text.length()];
			plainTxtKeys = text.toUpperCase().toCharArray();
			String morseValue = new String();

			for (char plainTxtKey : plainTxtKeys) {
				if (encoder.containsKey(plainTxtKey)) {
					morseValue = encoder.get(plainTxtKey);
					morseBuilder.append(morseValue + " ");
				}

				if (!encoder.containsKey(plainTxtKey)) {
					if (plainTxtKey == ' ') {
						morseBuilder.append('/');
					} else {
						throw new IllegalArgumentException(
								String.format("Illegal character encountered: %s [%s]", text, plainTxtKey));
					}

				}
			}
			return morseBuilder.toString().replaceAll(" /", "/").trim();
		}
	}

	/**
	 * Decodes a string of Morse Code to plain text English using a <code>StringBuffer()</code> to
	 * build the string
	 * @param code the string of Morse Code to be decoded
	 * @return <code>englishBuilder</code> as the new string of plain text English
	 */
	public static String decode(String code) {
		if (code == null) {
			throw new NullPointerException("Code cannot be null");
		} else {
			String[] morseWords = code.split("/");
			StringBuffer englishBuilder = new StringBuffer();

			for (int mwi = 0; mwi < morseWords.length; mwi++) {
				String[] morseLetters = morseWords[mwi].split(" ");
				for (int mli = 0; mli < morseLetters.length; mli++) {
					englishBuilder.append(decoder.decodeLetter(morseLetters[mli], englishBuilder));
				}
				englishBuilder.append(" ");
			}
			return englishBuilder.toString().toUpperCase().trim();
		}
	}

	/**
	 * Returns a new Map used for the encoding process and building the decoding tree
	 * @return new <code>EncodeMap()</code> 
	 */
	public static Map<Character, String> getEncodingMap() {
		return encoder;
	}

	/**
	 * Returns the root node of the decoding tree used in the decoding process.
	 * @return new <code>DecodeTree</code> root node
	 */
	public static TreeNode<Character> getDecodingTree() {
		return decoder;
	}
}