package adventOfCode.AdventOfCode.nine;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import adventOfCode.AdventOfCode.generic.PackageConstants;

class AdventNineCoreTest {
	
	AdventNineCore core;
	String filename = PackageConstants.pathRoot + "\\nine\\Test.txt";

	@BeforeEach
	void setUp() throws Exception {
		core  = new AdventNineCore();
	}

	@Test
	void testCalculateScore() throws IOException {
		ArrayList<Instruction> instructions = core.readFile(filename);
		int act = core.calculateScore(instructions);
		assertEquals(36, act);
	}

	@Test
	void testReadFile() throws IOException {
		ArrayList<Instruction> instructions = core.readFile(filename);
		assertNotNull(instructions);
	}

}
