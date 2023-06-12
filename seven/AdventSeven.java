package adventOfCode.AdventOfCode.seven;

import java.io.IOException;
import adventOfCode.AdventOfCode.generic.PackageConstants;;

public class AdventSeven {
	
	public static void main(String[] args) throws IOException {
		String filename = PackageConstants.pathRoot + "\\seven\\PRD.txt";
		
		AdventSevenCore core = new AdventSevenCore();
		Directory dir = core.readFile(filename);
		int score = core.calculateScore(dir);
		System.out.println(score);
	}
}
