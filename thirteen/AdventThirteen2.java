package adventOfCode.AdventOfCode.thirteen;

import java.io.IOException;
import java.util.ArrayList;
import adventOfCode.AdventOfCode.generic.PackageConstants;

public class AdventThirteen2 {

	public static void main(String[] args) throws IOException {
		String filename = PackageConstants.pathRoot + "\\thirteen\\PRD.txt";
		
		AdventThirteenCore2 core = new AdventThirteenCore2();
		ArrayList<String[]> instructions = core.readFile(filename);
		int sum = core.calculateScore(instructions);
		System.out.println(sum);
	
	}	
}
