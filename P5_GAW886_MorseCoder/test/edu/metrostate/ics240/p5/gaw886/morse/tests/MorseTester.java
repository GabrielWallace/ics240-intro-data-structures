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
	public void testEncoding() {
		String line = new String();
		String filePath = new String("/data/morseCode.txt");
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
		assertEquals("**** * *-** *-** --- --**--/*-- --- *-* *-** -** -*-*--", MorseCode.encode("Hello, World!"));
		//System.out.println(MorseCode.encode("Hello, World!"));
	}
	
	@Test
	public void testDecoding() {
		String line = new String();
		String filePath = new String("/data/morseCode.txt");
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
		
		assertEquals("HELLO, WORLD!", MorseCode.decode("**** * *-** *-** --- --**--/*-- --- *-* *-** -** -*-*--"));
		//System.out.println(MorseCode.decode("**** * *-** *-** --- --**--/*-- --- *-* *-** -** -*-*--"));
	}
	
	@Test
	public void testCraziness() {
		assertEquals("- **** */**-* ** ***- */-*** --- -**- ** -* --*/*-- ** --** *- *-* -** ***/*--- **- -- *--*/--*- **- ** -*-* -*- *-** -*--", MorseCode.encode("The five boxing wizards jump quickly"));
		
		assertEquals("*-** **- -*-* *- ***/** *--* *** **- --/-** --- *-** --- *-*/*** ** -/*- -- * -/--- -*** **/*-- *- -*/--*- **- **/--* --- -*/- *- - --- --- ** -* */-- --- -*/**** **- - -/-** *- *-* - ****/-*** --- - **** *- -*/-- *- -* -** *- *-** --- *-* */-** --- --- -*- **-/*- -* - ** *-** *-** * *** *-*-*-/*** -*- -*-- *-- *- *-** -*- * *-*/**** **- - -/-*- *- *** **** -*-- -*-- -*-- -*-/* *-- --- -*-/- **- *** -*- * -*/*-* *- ** -** * *-*/-** --- --- -*- **-/*--* *- -** -- */-** *- *-* - ****/*** -*- -*-- *-- *- *-** -*- * *-* *-*-*-/-- *- -*-* */*-** * ** *-/- *- - --- --- ** -* */**-* * - -/-** *- *-* - **** *-*-*-/-*-* **** * *-- -*** *- -*-* -*-* *-/-** *- *-* - ****/-- --- **-* **-*/-*** --- -*** *-/-*-- *- ***- ** -*/**- - *- *--* *- **- *-*-*-/*-- *- -- *--* *-/* *-- --- -*-/*- **** *** --- -*- *-/*- -* *- -*- ** -* *-*-*-/* -* -** --- *-*/-*-* *- *-** *- -- *- *-* **/-*-- --- -** *-/- *-- **/*-** * -*-/*- **** *** --- -*- *- *-*-*-/*** * -*-* **- *-* *-/*- -* - ** *-** *-** * ***/*--- ** -* -*/-*** * -*/- *- - --- --- ** -* * *-*-*-/**-* * - -/-*-* *- *-** *- -- *- *-* **/-- --- **-* **-*/*** -*- -*-- *-- *- *-** -*- * *-*/-** *- *-* - ****/*** -*- -*-- *-- *- *-** -*- * *-* *-*-*-/-- *- **- *-**/*-** * ** *-/-*-* *- *-** *-* ** *** *** ** *- -*/-* *- -*** --- ---/*- -* - ** *-** *-** * ***/-** *- *-* - ****/--- -*** **/*-- *- -*/-*** --- - **** *- -*/*** -*- -*-- *-- *- *-** -*- * *-* *-*-*-/--- -*** **/*-- *- -*/*--- *- -* --* ---/--* --- -* -*-/-* *- -*** --- ---/*-* **---/-** **---/*- -* - ** *-** *-** * *** *-*-*-/**-* * - -/-*-- --- -** *-/-- *- *-* *-/-** *- *-* - **** *-*-*-", MorseCode.encode("Lucas ipsum dolor sit amet obi wan qui gon tatooine mon hutt darth bothan mandalore dooku antilles. Skywalker hutt kashyyyk ewok tusken raider dooku padme darth skywalker. Mace leia tatooine fett darth. Chewbacca darth moff boba yavin utapau. Wampa ewok ahsoka anakin. Endor calamari yoda twi lek ahsoka. Secura antilles jinn ben tatooine. Fett calamari moff skywalker darth skywalker. Maul leia calrissian naboo antilles darth obi wan bothan skywalker. Obi wan jango gonk naboo r2 d2 antilles. Fett yoda mara darth."));
		
		assertEquals("THESE ARE THE VOYAGES OF THE STARSHIP ENTERPRISE. ITS CONTINUING MISSION, TO EXPLORE STRANGE NEW WORLDS, TO SEEK OUT NEW LIFE AND NEW CIVILIZATIONS, TO BOLDLY GO WHERE NO ONE HAS GONE BEFORE. WE NEED TO NEUTRALIZE THE HOMING SIGNAL. EACH UNIT HAS TOTAL ENVIRONMENTAL CONTROL, GRAVITY, TEMPERATURE, ATMOSPHERE, LIGHT, IN A PROTECTIVE FIELD. SENSORS SHOW ENERGY READINGS IN YOUR AREA. WE HAD A FORCED CHAMBER EXPLOSION IN THE RESONATOR COIL. FIELD STRENGTH HAS INCREASED BY 3,000 PERCENT. RESISTANCE IS FUTILE.", MorseCode.decode("- **** * *** */*- *-* */- **** */***- --- -*-- *- --* * ***/--- **-*/- **** */*** - *- *-* *** **** ** *--*/* -* - * *-* *--* *-* ** *** * *-*-*-/** - ***/-*-* --- -* - ** -* **- ** -* --*/-- ** *** *** ** --- -* --**--/- ---/* -**- *--* *-** --- *-* */*** - *-* *- -* --* */-* * *--/*-- --- *-* *-** -** *** --**--/- ---/*** * * -*-/--- **- -/-* * *--/*-** ** **-* */*- -* -**/-* * *--/-*-* ** ***- ** *-** ** --** *- - ** --- -* *** --**--/- ---/-*** --- *-** -** *-** -*--/--* ---/*-- **** * *-* */-* ---/--- -* */**** *- ***/--* --- -* */-*** * **-* --- *-* * *-*-*-/*-- */-* * * -**/- ---/-* * **- - *-* *- *-** ** --** */- **** */**** --- -- ** -* --*/*** ** --* -* *- *-** *-*-*-/* *- -*-* ****/**- -* ** -/**** *- ***/- --- - *- *-**/* -* ***- ** *-* --- -* -- * -* - *- *-**/-*-* --- -* - *-* --- *-** --**--/--* *-* *- ***- ** - -*-- --**--/- * -- *--* * *-* *- - **- *-* * --**--/*- - -- --- *** *--* **** * *-* * --**--/*-** ** --* **** - --**--/** -*/*-/*--* *-* --- - * -*-* - ** ***- */**-* ** * *-** -** *-*-*-/*** * -* *** --- *-* ***/*** **** --- *--/* -* * *-* --* -*--/*-* * *- -** ** -* --* ***/** -*/-*-- --- **- *-*/*- *-* * *- *-*-*-/*-- */**** *- -**/*-/**-* --- *-* -*-* * -**/-*-* **** *- -- -*** * *-*/* -**- *--* *-** --- *** ** --- -*/** -*/- **** */*-* * *** --- -* *- - --- *-*/-*-* --- ** *-** *-*-*-/**-* ** * *-** -**/*** - *-* * -* --* - ****/**** *- ***/** -* -*-* *-* * *- *** * -**/-*** -*--/***-- --**-- ----- ----- -----/*--* * *-* -*-* * -* - *-*-*-/*-* * *** ** *** - *- -* -*-* */** ***/**-* **- - ** *-** * *-*-*-"));
	}
}
