package adventOfCode.AdventOfCode.six;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

import adventOfCode.AdventOfCode.generic.LocalFileReader;
import adventOfCode.AdventOfCode.generic.ModifyFileContents;

public class AdventSixCore {
	
	private final int codeLength;
	
	public AdventSixCore(int codeLength) {
		this.codeLength = codeLength;
	}
	
	public int calculateScore(String encryptedCode) {
		int result = 0;
		Character[] previousChars = new Character[codeLength];
		for(int i=0;i<codeLength;i++) {previousChars[i]='a';};
		
		char[] allChars = encryptedCode.toCharArray();
		for(int i=0;i<allChars.length;i++) {
			previousChars[i%codeLength] = allChars[i];
			TreeSet<Character> t = new TreeSet<Character>();
			t.addAll(Arrays.asList(previousChars));
			if(t.size()==codeLength && i>3) {
				result = i + 1;
				break;
			}
		}
		return result;
	}
	
	public ArrayList<String> readFile(String filename) throws IOException{
		LocalFileReader fileReader = new LocalFileReader(new FileModifier());
		FileModifier modifiedFile = (FileModifier) fileReader.returnStrings(filename);
		return modifiedFile.getResult();
	}
	
	private class FileModifier implements ModifyFileContents{
		
		private ArrayList<String> result = new ArrayList<String>();

		@Override
		public void processLine(String s) {
			result.add(s);
		}

		public ArrayList<String> getResult() {
			return result;
		}
		
	}
}
