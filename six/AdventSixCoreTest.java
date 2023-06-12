package adventOfCode.AdventOfCode.six;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adventOfCode.AdventOfCode.generic.PackageConstants;

class AdventSixCoreTest {

	AdventSixCore core;
	String filename = PackageConstants.pathRoot + "\\six\\Test.txt";

	@BeforeEach
	void setUp() throws Exception {
		core = new AdventSixCore(4);
	}
	
	@Test
	void calculateScore0() throws IOException {
		ArrayList<String> list = core.readFile(filename);
		int act = core.calculateScore(list.get(0));
		assertEquals(7, act);
	}
	
	@Test
	void calculateScore1() throws IOException {
		ArrayList<String> list = core.readFile(filename);
		int act = core.calculateScore(list.get(1));
		assertEquals(5, act);
	}
	
	@Test
	void calculateScore2() throws IOException {
		ArrayList<String> list = core.readFile(filename);
		int act = core.calculateScore(list.get(2));
		assertEquals(6, act);
	}
	
	@Test
	void calculateScore3() throws IOException {
		ArrayList<String> list = core.readFile(filename);
		int act = core.calculateScore(list.get(3));
		assertEquals(10, act);
	}
	
	@Test
	void calculateScore4() throws IOException {
		ArrayList<String> list = core.readFile(filename);
		int act = core.calculateScore(list.get(4));
		assertEquals(11, act);
	}

	@Test
	void readFile() throws IOException {
		ArrayList<String> list = core.readFile(filename);
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

}
