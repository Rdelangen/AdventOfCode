package adventOfCode.AdventOfCode.thirteen;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import adventOfCode.AdventOfCode.generic.PackageConstants;

class AdventThirteenCoreTest {

	AdventThirteenCore core;
	String filename = PackageConstants.pathRoot + "\\thirteen\\test.txt";

	@BeforeEach
	void setUp() throws Exception {
		core  = new AdventThirteenCore();
	}

	@Test
	void testCalculateScore() throws IOException {
		ArrayList<AList> instructions = core.readFile(filename);
		int act = core.calculateScore(instructions);
		assertEquals(13, act);
	}
	
	@Test
	void testCalculateScore2() throws IOException {
		String filename2 = PackageConstants.pathRoot + "\\thirteen\\test2.txt";
		ArrayList<AList> instructions = core.readFile(filename2);
		int act = core.calculateScore(instructions);
		assertEquals(121, act);
	}


}
