package adventOfCode.AdventOfCode.eight;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adventOfCode.AdventOfCode.generic.PackageConstants;

class AdventEightCore2Test {

	AdventEightCore2 core;
	String filename = PackageConstants.pathRoot + "\\eight\\Test.txt";

	@BeforeEach
	void setUp() throws Exception {
		core  = new AdventEightCore2();
	}

	@Test
	void testCalculateScore() throws IOException {
		ArrayList<ArrayList<Integer>> trees = core.readFile(filename);
		int act = core.calculateScore(trees);
		assertEquals(8, act);
	}

	@Test
	void testReadFile() throws IOException {
		ArrayList<ArrayList<Integer>> trees = core.readFile(filename);
		assertNotNull(trees);
	}

}
