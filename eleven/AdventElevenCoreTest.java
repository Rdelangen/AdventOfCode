package adventOfCode.AdventOfCode.eleven;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adventOfCode.AdventOfCode.generic.PackageConstants;

class AdventElevenCoreTest {

	AdventElevenCore core;
	String filename = PackageConstants.pathRoot + "\\eleven\\test.txt";

	@BeforeEach
	void setUp() throws Exception {
		core  = new AdventElevenCore();
	}

	@Test
	void testCalculateScore() throws IOException {
		ArrayList<Monkey> instructions = core.readFile(filename);
		int act = core.calculateScore(instructions);
		assertEquals(10605, act);
	}

	@Test
	void testReadFile() throws IOException {
		ArrayList<Monkey> instructions = core.readFile(filename);
		assertNotNull(instructions);
	}

}
