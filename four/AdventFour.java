package adventOfCode.AdventOfCode.four;

import java.io.IOException;
import java.util.ArrayList;

import adventOfCode.AdventOfCode.generic.PackageConstants;

public class AdventFour {

	public static void main(String[] args) throws IOException {
		String filename = PackageConstants.pathRoot + "\\four\\PRD.txt";
		
		AdventFourCore core = new AdventFourCore();
		ArrayList<String[]> list = core.readFile(filename);
		int sum = core.calculateScore(list);
		System.out.println(sum);

	}

}
