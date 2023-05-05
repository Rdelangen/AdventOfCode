package adventOfCode.AdventOfCode.three;

import java.io.IOException;
import java.util.ArrayList;

public class AdventThree {

	public static void main(String[] args) throws IOException {
		String filename = "C:\\Users\\ronald.delangen\\eclipse-workspace\\JAVA_Tutorial\\src\\adventOfCode\\AdventOfCode\\three\\PRD.txt";
		
		AdventThreeCore core = new AdventThreeCore();
		ArrayList<String[]> list = core.readFile(filename);
		int sum = core.calculateScore(list);
		System.out.println(sum);

	}

}
