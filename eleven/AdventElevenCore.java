package adventOfCode.AdventOfCode.eleven;

import java.io.IOException;
import java.util.ArrayList;

import adventOfCode.AdventOfCode.generic.LocalFileReader;
import adventOfCode.AdventOfCode.generic.ModifyFileContents;

public class AdventElevenCore {
	
	public int calculateScore() {
		return 0;
	}

	public ArrayList<Integer> readFile(String filename) throws IOException{
		LocalFileReader fileReader = new LocalFileReader(new FileModifier());
		FileModifier modifiedFile = (FileModifier) fileReader.returnStrings(filename);
		return modifiedFile.returnString();
	}
	
	private class FileModifier implements ModifyFileContents{
		
		private ArrayList<Integer> result = new ArrayList<>();

		@Override
		public void processLine(String s) {
			String[] strings = s.split(" ");
			result.add(1);
		}	
		
		public ArrayList<Integer> returnString() {	
			return result;
		}
	}
}
