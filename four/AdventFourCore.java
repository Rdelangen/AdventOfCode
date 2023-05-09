package adventOfCode.AdventOfCode.four;

import java.io.IOException;
import java.util.ArrayList;

import adventOfCode.AdventOfCode.generic.*;

public class AdventFourCore {
	
	public int calculateScore(ArrayList<String[]> list) {
		return (int) list.stream().map(this::convert).filter(this::filter).count();
	}
	
	public int[] convert(String[] s) {
		int[] ranges = new int[s.length];
		for(int i=0;i<s.length;i++) {
			ranges[i] = Integer.parseInt(s[i]);
		}
		return ranges;
	}
	
	public boolean filter(int i[]) {
		return i[0]<=i[2] && i[1]>=i[3]
			|| i[0]>=i[2] && i[1]<=i[3];
	}
	
	
	public ArrayList<String[]> readFile(String filename) throws IOException{
		LocalFileReader fileReader = new LocalFileReader(new FileModifier());
		return fileReader.returnStrings(filename);
	}
	
	private class FileModifier implements ModifyFileContents{
		
		private ArrayList<String[]> result = new ArrayList<String[]>();

		@Override
		public void processLine(String s) {
			result.add(s.split("[,-]"));
		}

		@Override
		public ArrayList<String[]> getResult() {
			return result;
		}
		
	}
}