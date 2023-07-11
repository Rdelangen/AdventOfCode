package adventOfCode.AdventOfCode.ten;

import java.io.IOException;
import java.util.ArrayList;

import adventOfCode.AdventOfCode.generic.PackageConstants;

public class AdventTen {

	public static void main(String[] args) throws IOException {
		String filename = PackageConstants.pathRoot + "\\ten\\PRD.txt";
		
		AdventTenCore core = new AdventTenCore();
		ArrayList<Line> instructions = core.readFile(filename);
		int sum = core.calculateScore(instructions);
		System.out.println(sum);

	}

}
