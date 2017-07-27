package edu.metrostate.ics240.p5.gaw886.morse;

import java.util.Map;
import edu.metrostate.ics240.p5.gaw886.morse.DecodeTree.MorseNode;
import edu.metrostate.ics240.p5.morse.TreeNode;

public class MorseCode {

	public static String encode(String text) {
		Map<Character, String> encoder = getEncodingMap();
		String morseEncodedString = new String();
		if (text == null) {
			throw new NullPointerException("Text cannot be null");
		} else {
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
				morseEncodedString = morseBuilder.toString().replaceAll(" /", "/").trim();
			}
			return morseEncodedString;
		}
	}

	public static String decode(String code) {
		TreeNode<Character> decodeTree = getDecodingTree();
		if (code == null) {
			throw new NullPointerException("Code cannot be null");
		}
		String path = code;
		String nodeKey = "";
		TreeNode<Character> currNode = decodeTree;

		for (int i = 0; i < path.length(); i++) {
			nodeKey = path.substring(i, i + 1);
			System.out.println(nodeKey);
			if (nodeKey.equals("-")) {
				if (((MorseNode) currNode).hasLeftChild()) {
					currNode = currNode.getLeftChild();
				} else {
					throw new RuntimeException("Code pattern not found.");
				}
			} else if (nodeKey.equals("*")) {
				if (((MorseNode) currNode).hasRightChild()) {
					currNode = currNode.getRightChild();
				} else {
					throw new RuntimeException("Code pattern not found. ");
				}
				//System.out.println(currNode.getValue().toString());
			}
		}
		return currNode.getValue().toString();
	}

	public static Map<Character, String> getEncodingMap() {
		return new EncodeMap().buildMap();
	}

	public static TreeNode<Character> getDecodingTree() {
		return new DecodeTree().buildDecodingTree().getRoot();
	}
}