package adventOfCode.AdventOfCode.thirteen;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import adventOfCode.AdventOfCode.generic.PackageConstants;

class AdventThirteenCoreTest2 {

	AdventThirteenCore2 core;

	@BeforeEach
	void setUp() throws Exception {
		core  = new AdventThirteenCore2();
	}

	@Test
	void testCalculateScore() throws IOException {
		String filename = PackageConstants.pathRoot + "\\thirteen\\test.txt";
		ArrayList<String[]> instructions = core.readFile(filename);
		int act = core.calculateScore(instructions);
		assertEquals(13, act);
	}
	
	@Test
	void testCalculateScore2() throws IOException {
		String filename = PackageConstants.pathRoot + "\\thirteen\\test2.txt";
		ArrayList<String[]> instructions = core.readFile(filename);
		int act = core.calculateScore(instructions);
		assertEquals(121, act);
	}

}
