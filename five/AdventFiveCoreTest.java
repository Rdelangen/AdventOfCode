package adventOfCode.AdventOfCode.five;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adventOfCode.AdventOfCode.five.AdventFiveCore.fileContents;

class AdventFiveCoreTest {
	
	AdventFiveCore core;
	String filename = "C:\\Users\\ronald.delangen\\eclipse-workspace\\JAVA_Tutorial\\src\\adventOfCode\\AdventOfCode\\five\\Test.txt";

	@BeforeEach
	void setUp() throws Exception {
		core = new AdventFiveCore();
	}
	
	@Test
	void testGetLastBlocks() throws IOException {
		fileContents fileContent = core.readFile(filename);
		String act = core.getFirstBlocks(fileContent);
		assertEquals("CMZ", act);
	}

	@Test
	void testReadFile() throws IOException {
		fileContents act = core.readFile(filename);
		assertNotNull(act);
		assertFalse(act.blocks.isEmpty());
	}

}
