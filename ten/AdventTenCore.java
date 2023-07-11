package adventOfCode.AdventOfCode.ten;

import java.io.IOException;
import java.util.ArrayList;

import adventOfCode.AdventOfCode.generic.LocalFileReader;
import adventOfCode.AdventOfCode.generic.ModifyFileContents;

public class AdventTenCore {
	
	//Part one ~20 min
	//Total 37:33:01
	
	private int cycle = 0;
	
	public int calculateScore(ArrayList<Line> list) {
		int x = 1, result = 0;
		cycle=0;
		for(Line l:list) {
			if(l.instruction.equals("noop")) {
				result += addCycle(x);
			}
			if(l.instruction.equals("addx")) {
				result += addCycle(x);;
				result += addCycle( x);
				x += l.number;	
			}
		}
		return result;
	}
	
	private int addCycle(int x) {
		int result = 0;
//		if((cycle-20)%40==0) {
//			result = x * cycle;
//		}
		
		if (cycle%40==0){
			System.out.println();
		}
		
		if(cycle%40 >= x-1 && cycle%40 <= x+1) {
			System.out.print("#");
		}else {
			System.out.print(".");
		}
		
		cycle++;
		
		return result;
	}

	public ArrayList<Line> readFile(String filename) throws IOException{
		LocalFileReader fileReader = new LocalFileReader(new FileModifier());
		FileModifier modifiedFile = (FileModifier) fileReader.returnStrings(filename);
		return modifiedFile.returnString();
	}
	
	private class FileModifier implements ModifyFileContents{
		
		private ArrayList<Line> result = new ArrayList<>();

		@Override
		public void processLine(String s) {
			String[] strings = s.split(" ");
			int number = strings.length>1 ? Integer.parseInt(strings[1]) : 0;
			result.add(new Line(strings[0], number));
		}	
		
		public ArrayList<Line> returnString() {	
			return result;
		}
	}

}
