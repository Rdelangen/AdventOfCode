package adventOfCode.AdventOfCode.two;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdventTwoCoreTest {
	
	AdventTwoCore cut;
	String filename = "C:\\Users\\ronald.delangen\\eclipse-workspace\\JAVA_Tutorial\\src\\adventOfCode\\AdventOfCode\\two\\Test.txt";

	@BeforeEach
	void setUp() throws Exception {
		cut = new AdventTwoCore();
	}

	@Test
	void testCalculateScore() throws IOException {
		ArrayList<String[]> list = cut.readFile(filename);
		assertEquals(15, cut.calculateScore(list));
	}

	@Test
	void testReadFile() throws IOException {
		ArrayList<String[]> act = cut.readFile(filename);
		assertNotNull(act);
		assertFalse(act.isEmpty());
	}
	
	@Test
	void testCalculateScoreV2() throws IOException {
		ArrayList<String[]> list = cut.readFile(filename);
		assertEquals(12, cut.calculateScoreV2(list));
	}

}
