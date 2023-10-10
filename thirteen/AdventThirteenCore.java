package adventOfCode.AdventOfCode.thirteen;

import java.io.IOException;
import java.util.ArrayList;
import adventOfCode.AdventOfCode.generic.LocalFileReader;
import adventOfCode.AdventOfCode.generic.ModifyFileContents;

public class AdventThirteenCore {

	// 2H no solution
	
	public int calculateScore(ArrayList<AList> list) {
		int score = 0;
		for(int i=0;i<list.size();i+=2) {
//			printLists(score, i, list.get(i), list.get(i+1));
			if (list.get(i).compareTo(list.get(i+1)) < 0) {
				score += (i+2)/2;
			}
		}
		return score;
	}
	
	private void printLists(int score, int iteration, AList left, AList right) {
		System.out.println("Score: " + score + "	Iteration: " + (iteration+2)/2 + "	Totaal: " + (score + (iteration+2)/2));
		System.out.println(left);
		System.out.println(right);
		System.out.println();
	}

	public ArrayList<AList> readFile(String filename) throws IOException{
		LocalFileReader fileReader = new LocalFileReader(new FileModifier());
		FileModifier modifiedFile = (FileModifier) fileReader.returnStrings(filename);
		return modifiedFile.returnString();
	}
	
	private class FileModifier implements ModifyFileContents{
		
		private ArrayList<AList> result = new ArrayList<>();
		int i;
		char[] chars;

		@Override
		public void processLine(String s) {
			
			if(s.isBlank()) {return;}
			
			i = 1;
			chars = s.toCharArray();
			AList l = processChar();
			result.add(l);
		}
		
		private AList processChar() {
			AList l = new AList();
			while(i<chars.length) {
				char c = chars[i];
				i++;
				switch (c) {
				case '[':
					l.addElement(processChar());
					break;
				case ']':
					return l;
				case ',':
					break;
				default:
					int number = getNumber(c);
					l.addElement(new AElement(number));
					break;
				}
			}
			return l;
		}
		
		private int getNumber(char c) {
			if(c=='1'&&chars[i]=='0') {
				i++;
				return 10;
			}
			return Integer.parseInt(""+c);
		}
		
		public ArrayList<AList> returnString() {	
			return result;
		}
	}
}
