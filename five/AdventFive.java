package adventOfCode.AdventOfCode.five;

import java.io.IOException;

import adventOfCode.AdventOfCode.five.AdventFiveCore.fileContents;
import adventOfCode.AdventOfCode.generic.PackageConstants;

public class AdventFive {

	public static void main(String[] args) throws IOException {
		String filename = PackageConstants.pathRoot + "\\five\\PRD.txt";
		
		AdventFiveCoreV2 core = new AdventFiveCoreV2();
		fileContents fileContent = core.readFile(filename);
		String firstBlocks = core.getFirstBlocks(fileContent);
		System.out.println(firstBlocks);

	}

}
