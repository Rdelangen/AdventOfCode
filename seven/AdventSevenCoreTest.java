package adventOfCode.AdventOfCode.seven;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adventOfCode.AdventOfCode.generic.PackageConstants;
class AdventSevenCoreTest {
	
	AdventSevenCore core;
	String filename = PackageConstants.pathRoot + "\\seven\\Test.txt";

	@BeforeEach
	void setUp() throws Exception {
		core  = new AdventSevenCore();
	}

	@Test
	void testCalculateScore() throws IOException {
		Directory root = core.readFile(filename);
		int act = core.calculateScore(root);
		assertEquals(95437, act);
	}

	@Test
	void testReadFile() throws IOException {
		FileSystem directories = core.readFile(filename);
		assertNotNull(directories);
	}

}
