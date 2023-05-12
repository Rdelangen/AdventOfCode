package adventOfCode.AdventOfCode.five;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adventOfCode.AdventOfCode.five.AdventFiveCore.fileContents;

class AdventFiveCoreV2Test {

	AdventFiveCoreV2 core;
	String filename = "C:\\Users\\ronald.delangen\\eclipse-workspace\\JAVA_Tutorial\\src\\adventOfCode\\AdventOfCode\\five\\Test.txt";

	@BeforeEach
	void setUp() throws Exception {
		core = new AdventFiveCoreV2();
	}
	
	@Test
	void testGetLastBlocks() throws IOException {
		fileContents fileContent = core.readFile(filename);
		String act = core.getFirstBlocks(fileContent);
		assertEquals("MCD", act);
	}

}
