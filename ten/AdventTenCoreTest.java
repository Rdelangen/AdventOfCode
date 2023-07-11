package adventOfCode.AdventOfCode.ten;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adventOfCode.AdventOfCode.generic.PackageConstants;
class AdventTenCoreTest {

	AdventTenCore core;
	String filename = PackageConstants.pathRoot + "\\ten\\test.txt";

	@BeforeEach
	void setUp() throws Exception {
		core  = new AdventTenCore();
	}

	@Test
	void testCalculateScore() throws IOException {
		ArrayList<Line> instructions = core.readFile(filename);
		int act = core.calculateScore(instructions);
		assertEquals(13140, act);
	}

	@Test
	void testReadFile() throws IOException {
		ArrayList<Line> instructions = core.readFile(filename);
		assertNotNull(instructions);
	}

}
