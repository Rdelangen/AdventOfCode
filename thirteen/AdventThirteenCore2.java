package adventOfCode.AdventOfCode.thirteen;

import java.io.IOException;
import java.util.ArrayList;
import adventOfCode.AdventOfCode.generic.LocalFileReader;
import adventOfCode.AdventOfCode.generic.ModifyFileContents;

public class AdventThirteenCore2 {

	// 2H no solution
	
	public int calculateScore(ArrayList<String[]> list) {
		int score = 0;
		for(int i=0;i<list.size();i++) {
			String[] stringList = list.get(i);
			char[] left = stringList[0].toCharArray();
			char[] right = stringList[1].toCharArray();
			// First position can be skipped, it is always a '['
			int leftPos = -1, rightPos = -1;
			while(leftPos < stringList[0].length() && rightPos < stringList[1].length()) {
				if(leftPos + 1 == stringList[0].length()) {
					printLists(score, i, left, right);
					score = addScore(score, i);
					break;
				}
				if (rightPos + 1 == stringList[1].length()) {
					printLists(score, i, left, right);
					break;
				}
				leftPos++;rightPos++;
				char leftChar = left[leftPos], rightChar = right[rightPos];
				if (leftChar == rightChar) {
					continue;
				}
				
				if(leftChar==']') {
					printLists(score, i, left, right);
					score = addScore(score, i);
					break;
				}
				if(rightChar==']') {
					printLists(score, i, left, right);
					break;
				}
				
				if(leftChar < rightChar) {
					printLists(score, i, left, right);
					score = addScore(score, i);
					break;
				}
				printLists(score, i, left, right);
				break;
//				
//				if(leftChar!=',' && leftChar!='[') {
//					int rightPos2 = rightPos;
//					while (rightChar=='[') {
//						rightPos2++;
//						rightChar = right[rightPos2];
//					}
//					if (leftChar==rightChar) {
//						continue;
//					}
//					if (leftChar < rightChar && rightChar != ']') {
//						score += (i + 1);
//					}
//					break;
//				}
//				
//				if(rightChar!=',' && rightChar!='[') {
//					int leftPos2 = leftPos;
//					while (leftChar=='[') {
//						leftPos2++;
//						leftChar = left[leftPos2];
//					}
//					if (rightChar==leftChar) {
//						continue;
//					}
//					if (leftChar < rightChar || leftChar == ']') {
//						score += (i + 1);
//					}
//					break;
//				}
			}
		}
		return score;
	}
	
	private int addScore(int score, int iteration) {
		return score + iteration + 1;
	}
	
	private void printLists(int score, int iteration, char[] left, char[] right) {
		System.out.println("Score: " + score + "	Iteration: " + iteration + "	Totaal: " + (iteration+score + 1));
		System.out.println(left);
		System.out.println(right);
		System.out.println();
	}

	public ArrayList<String[]> readFile(String filename) throws IOException{
		LocalFileReader fileReader = new LocalFileReader(new FileModifier());
		FileModifier modifiedFile = (FileModifier) fileReader.returnStrings(filename);
		return modifiedFile.returnString();
	}
	
	private class FileModifier implements ModifyFileContents{
		
		private ArrayList<String> result = new ArrayList<>();
		@Override
		public void processLine(String s) {
			
			if(s.isBlank()) {return;}
			s = s.replace("10", "A");
			s = s.replace("[","");
			s = s.replace(",","");
			result.add(s);
		}
		
		
		public ArrayList<String[]> returnString() {	
			ArrayList<String[]> stringList = new ArrayList<>();
			for(int i=0;i<result.size();i+=2) {
				String[] s = {result.get(i),result.get(i+1)};
				stringList.add(s);
			}
			return stringList;
		}
	}
}
