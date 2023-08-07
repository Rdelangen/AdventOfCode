package adventOfCode.AdventOfCode.twelve;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import adventOfCode.AdventOfCode.generic.PackageConstants;

class AdventTwelveCoreTest {

	AdventTwelveCore core;
	String filename = PackageConstants.pathRoot + "\\twelve\\test.txt";

	@BeforeEach
	void setUp() throws Exception {
		core  = new AdventTwelveCore();
	}

	@Test
	void testCalculateScore() throws IOException {
		ArrayList<ArrayList<Integer>> instructions = core.readFile(filename);
		int act = core.calculateScore(instructions);
		assertEquals(29, act);
	}

	@Test
	void testReadFile() throws IOException {
		ArrayList<ArrayList<Integer>> instructions = core.readFile(filename);
		assertNotNull(instructions);
	}

}
