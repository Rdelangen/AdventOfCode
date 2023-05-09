package adventOfCode.AdventOfCode.four;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adventOfCode.AdventOfCode.generic.PackageConstants;

class AdventFourCoreV2Test {
	
	AdventFourCoreV2 core;
	String filename = PackageConstants.pathRoot + "\\four\\Test.txt";

	@BeforeEach
	void setUp() throws Exception {
		core = new AdventFourCoreV2();
	}

	@Test
	void calculateScore() throws IOException {
		ArrayList<String[]> list = core.readFile(filename);
		int act = core.calculateScore(list);
		assertEquals(4, act);
	}

}
