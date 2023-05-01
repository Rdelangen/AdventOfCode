package adventOfCode.AdventOfCode.two;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AdventTwoCore {
	
	public int calculateScore(ArrayList<String[]> book) {
		return book.stream().map(this::convert).map(this::convertToInt).reduce(0, Integer::sum);
	}
	
	private String[] convert(String s[]) {
		String[] res = { 
					switch(s[0].toUpperCase()) { 
						case "A" -> "R";
						case "B" -> "P";
						case "C" -> "S";
						default  -> ""; },
					switch(s[1].toUpperCase()) { 
						case "X" -> "R";
						case "Y" -> "P";
						case "Z" -> "S";
						default  -> ""; }};
		return res;
	}
	
	private int convertToInt(String s[]) {
		int result = switch(s[1].toUpperCase()) { 
			case "R" -> 1;
			case "P" -> 2;
			case "S" -> 3;
			default  -> 0; };
			
		result += calculateVictory(s[0], s[1]);
		return result;
	}
	
	
	private int calculateVictory(String s1, String s2) {
		if (s1.equals(s2)){ return 3;}
		if (s1.equals("R") && s2.equals("P")
		 || s1.equals("P") && s2.equals("S")
		 || s1.equals("S") && s2.equals("R")){ return 6;}
		return 0;
	}
	
	public ArrayList<String[]> readFile(String filename) throws IOException{
		ArrayList<String[]> result = new ArrayList<String[]>();
		
		BufferedReader reader = null;
		try {
			String c;
			reader = new BufferedReader(new FileReader(filename));		
			while(true) {
				c = reader.readLine();
				if(c==null) {break;};
				
				result.add(c.split(" "));
			}
		} finally {
			if (reader != null){reader.close();}
		}
		
		return result;
	}
	
}
