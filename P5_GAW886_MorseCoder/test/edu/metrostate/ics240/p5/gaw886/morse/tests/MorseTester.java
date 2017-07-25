package edu.metrostate.ics240.p5.gaw886.morse.tests;

import static org.junit.Assert.fail;

import org.junit.Test;

import edu.metrostate.ics240.p5.gaw886.morse.MorseCode;
import edu.metrostate.ics240.p5.gaw886.morse.MorseNode;
import edu.metrostate.ics240.p5.gaw886.morse.MorseTree;

public class MorseTester {
	@Test
	public void testEncoding() {
		MorseCode.encode("Hello, World.");
		MorseCode.encode("Hello, World?");
		MorseCode.encode("Hello, World!");
		MorseCode.encode("Hello, World");
		MorseCode.encode("Hello, World)");
		MorseCode.encode("Hello, World:");
		MorseCode.encode("Hello, World;");
		MorseCode.encode("Hello, World@");
		System.out.println(MorseCode.encode("Jackdaws love my big sphinx of quartz"));

		try {
			MorseCode.encode("Hello, World$"); // illegal value
			fail("Expected exception");
		} catch (IllegalArgumentException iae) {
			// expected
		}
	}

	@Test
	public void testTree() {
		MorseTree<Character> morseNode = new MorseTree<>();
		
		 	morseNode.insert('0',"-----");
	        morseNode.insert('1',"·----");
	        morseNode.insert('2',"··---");
	        morseNode.insert('3',"···--");
	        morseNode.insert('4',"····-");
	        morseNode.insert('5',"·····");
	        morseNode.insert('6',"-····");
	        morseNode.insert('7',"--···");
	        morseNode.insert('8',"---··");
	        morseNode.insert('9',"----·");
	        morseNode.insert('A',"·-");
	        morseNode.insert('B',"-···");
	        morseNode.insert('C',"-·-·");
	        morseNode.insert('D',"-··");
	        morseNode.insert('E',"·");
	        morseNode.insert('F',"··-·");
	        morseNode.insert('G',"--·");
	        morseNode.insert('H',"····");
	        morseNode.insert('I',"··");
	        morseNode.insert('J',"·---");
	        morseNode.insert('K',"-·-");
	        morseNode.insert('L',"·-··");
	        morseNode.insert('M',"--");
	        morseNode.insert('N',"-·");
	        morseNode.insert('O',"---");
	        morseNode.insert('P',"·--·");
	        morseNode.insert('Q',"--·-");
	        morseNode.insert('R',"·-·");
	        morseNode.insert('S',"···");
	        morseNode.insert('T',"-");
	        morseNode.insert('U',"··-");
	        morseNode.insert('V',"···-");
	        morseNode.insert('W',"·--");
	        morseNode.insert('X',"-··-");
	        morseNode.insert('Y',"-·--");
	        morseNode.insert('Z',"--··");
	        morseNode.insert('.',"*-*-*-");
	        morseNode.insert(',',"--**--");
	        morseNode.insert('?',"**--**");
	        morseNode.insert('!',"-*-*--");
	        morseNode.insert('(',"-*--*");
	        morseNode.insert(')',"-*--*-");
	        morseNode.insert(':',"---***");
	        morseNode.insert(';',"-*-*-*");
	        morseNode.insert('@',"*--*-*");
	        
	       morseNode.printInOrder();
	}
}
