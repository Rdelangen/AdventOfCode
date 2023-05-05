package adventOfCode.AdventOfCode.three;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdventThreeCoreTest {
	
	private AdventThreeCore core = new AdventThreeCore();
	private final String filename = "C:\\Users\\ronald.delangen\\eclipse-workspace\\JAVA_Tutorial\\src\\adventOfCode\\AdventOfCode\\three\\Test.txt";

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testCalculateScore() throws IOException{
		ArrayList<String[]> rucksack = core.readFile(filename);
		int act = core.calculateScore(rucksack);
		assertEquals(157, act);
	}

	@Test
	void test() throws IOException {
		ArrayList<String[]> act = core.readFile(filename);
		assertNotNull(act);
		assertFalse(act.isEmpty());
	}

}
