package adventOfCode.AdventOfCode.eleven;

import java.io.IOException;
import java.util.ArrayList;

import adventOfCode.AdventOfCode.generic.LocalFileReader;
import adventOfCode.AdventOfCode.generic.ModifyFileContents;

public class AdventElevenCore {
	
	// Part 1 after 1:06:46
	// Part 2 partial after 1:15:43
	
	public int calculateScore(ArrayList<Monkey> monkeys) {
		for(int i=0;i<10000;i++) {
			for(Monkey monkey : monkeys) {
				monkey.passToMonkey(monkeys);
			}
		}
		
		for(Monkey monkey : monkeys) {
			System.out.println(monkey.amountOfItems);
		}
		
		return 0;
	}

	public ArrayList<Monkey> readFile(String filename) throws IOException{
		LocalFileReader fileReader = new LocalFileReader(new FileModifier());
		FileModifier modifiedFile = (FileModifier) fileReader.returnStrings(filename);
		return modifiedFile.returnString();
	}
	
	private class FileModifier implements ModifyFileContents{
		
		private ArrayList<Monkey> result = new ArrayList<>();
		private int monkeyCounter=0;

		@Override
		public void processLine(String s) {
			
			int[][] values = {{3,2,3},{11,5,6},{19,3,1},{5,1,6},{2,2,0},{7,4,7},{17,5,7},{13,4,0}};
			int[][] operations = {{19,0,0},{1,8,0},{13,0,0},{1,6,0},{1,5,0},{0,0,1},{1,2,0},{1,3,0}};
//			int[][] values = {{23,2,3},{19,2,0},{13,1,3},{17,0,1}};
//			int[][] operations = {{19,0,0},{1,6,0},{0,0,1},{1,3,0}};
			
			Monkey newMonkey = null;
			if (!s.contains("Starting items:")) { return;}
			int[] value = values[monkeyCounter];
			int[] operation = operations[monkeyCounter];
		    newMonkey = new Monkey(value[0],value[1],value[2], operation[0],operation[1], operation[2]);
			String splitStrings[] = s.split(":");
			String numbers[] = splitStrings[1].split(",");
			
			for(String number : numbers) {
				newMonkey.addItem(Integer.parseInt(number.trim()));
			}
			
			result.add(newMonkey);
			monkeyCounter++;
					
		}	
		
		public ArrayList<Monkey> returnString() {	
			return result;
		}
		
	}
}
