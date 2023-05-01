package adventOfCode.AdventOfCode.one;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AdventOneCoreTest {
	
	String filename = "C:\\Users\\ronald.delangen\\eclipse-workspace\\JAVA_Tutorial\\src\\adventOfCode\\AdventOfCode\\one\\Test.txt";

	@Test
	void testGetIntegerList() throws IOException {
		int maxValue = 24000;
		int actualValue = new AdventOneCore().getIntegerList(filename).get(0).intValue();
		assertEquals(maxValue, actualValue);
	}
	
	@Test
	void testGetTopEntries() throws IOException {
		AdventOneCore core = new AdventOneCore();
		ArrayList<Integer> list = core.getIntegerList(filename);
		assertEquals(35000, core.sumTopEntries(list, 2));
	}

}
