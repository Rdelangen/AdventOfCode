package adventOfCode.AdventOfCode.six;

import java.io.IOException;
import java.util.ArrayList;

import adventOfCode.AdventOfCode.generic.PackageConstants;

public class AdventSix {
	
	public static void main(String[] args) throws IOException {
		String filename = PackageConstants.pathRoot + "\\six\\PRD.txt";
		
		AdventSixCore core = new AdventSixCore(14);
		ArrayList<String> list = core.readFile(filename);
		for(String s : list) {
			int sum = core.calculateScore(s);
			System.out.println(sum);
		}
	}

}
