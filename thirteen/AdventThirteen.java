package adventOfCode.AdventOfCode.thirteen;

import java.io.IOException;
import java.util.ArrayList;
import adventOfCode.AdventOfCode.generic.PackageConstants;

public class AdventThirteen {

	public static void main(String[] args) throws IOException {
		String filename = PackageConstants.pathRoot + "\\thirteen\\PRD2.txt";
		
		AdventThirteenCore core = new AdventThirteenCore();
		ArrayList<AList> instructions = core.readFile(filename);
		int sum = core.calculateScore(instructions);
		System.out.println(sum);
	}	
}
