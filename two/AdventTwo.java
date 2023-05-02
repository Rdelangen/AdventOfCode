package adventOfCode.AdventOfCode.two;

import java.io.IOException;
import java.util.ArrayList;

public class AdventTwo {

	public static void main(String[] args) throws IOException {
		String filename = "C:\\Users\\ronald.delangen\\eclipse-workspace\\JAVA_Tutorial\\src\\adventOfCode\\AdventOfCode\\two\\PRD.txt";
				
		AdventTwoCore core = new AdventTwoCore();
		ArrayList<String[]> list = core.readFile(filename);
		
		int sum = core.calculateScoreV2(list);
		System.out.println(sum);

	}

}
