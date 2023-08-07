package adventOfCode.AdventOfCode.twelve;

import java.io.IOException;
import java.util.ArrayList;
import adventOfCode.AdventOfCode.generic.PackageConstants;

public class AdventTwelve {

	public static void main(String[] args) throws IOException {
		String filename = PackageConstants.pathRoot + "\\twelve\\PRD.txt";
		
		AdventTwelveCore core = new AdventTwelveCore();
		ArrayList<ArrayList<Integer>> instructions = core.readFile(filename);
		int sum = core.calculateScore(instructions);
		System.out.println(sum);
	}

}
