package adventOfCode.AdventOfCode.eight;

import java.io.IOException;
import java.util.ArrayList;

import adventOfCode.AdventOfCode.generic.PackageConstants;

public class AdventEight {

	public static void main(String[] args) throws IOException {
		String filename = PackageConstants.pathRoot + "\\eight\\PRD.txt";
		
		AdventEightCore2 core = new AdventEightCore2();
		ArrayList<ArrayList<Integer>> list = core.readFile(filename);
		int score = core.calculateScore(list);
		System.out.println(score);

	}

}
