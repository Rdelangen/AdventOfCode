package adventOfCode.AdventOfCode.eleven;

import java.io.IOException;
import java.util.ArrayList;

import adventOfCode.AdventOfCode.generic.PackageConstants;

public class AdventEleven {

	public static void main(String[] args) throws IOException {
String filename = PackageConstants.pathRoot + "\\PRD\\PRD.txt";
		
		AdventElevenCore core = new AdventElevenCore();
		ArrayList<Integer> instructions = core.readFile(filename);
		int sum = core.calculateScore();
		System.out.println(sum);
	}

}
