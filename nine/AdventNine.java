package adventOfCode.AdventOfCode.nine;

import java.io.IOException;
import java.util.ArrayList;
import adventOfCode.AdventOfCode.generic.PackageConstants;

public class AdventNine {

	public static void main(String[] args) throws IOException {
		
		String filename = PackageConstants.pathRoot + "\\nine\\PRD.txt";
		
		AdventNineCore core = new AdventNineCore();
		ArrayList<Instruction> instructions = core.readFile(filename);
		int sum = core.calculateScore(instructions);
		System.out.println(sum);

	}

}
