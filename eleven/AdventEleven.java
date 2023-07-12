package adventOfCode.AdventOfCode.eleven;

import java.io.IOException;
import java.util.ArrayList;

import adventOfCode.AdventOfCode.generic.PackageConstants;

public class AdventEleven {

	public static void main(String[] args) throws IOException {
		String filename = PackageConstants.pathRoot + "\\eleven\\PRD.txt";
		
		AdventElevenCore core = new AdventElevenCore();
		ArrayList<Monkey> instructions = core.readFile(filename);
		int sum = core.calculateScore(instructions);
//		System.out.println(sum);
	}

}
