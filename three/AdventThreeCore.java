package adventOfCode.AdventOfCode.three;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AdventThreeCore {
	
	public int calculateScore(ArrayList<String[]> backpack) {
		return backpack.stream().map(this::toSet).map(this::convert).reduce(0,Integer::sum);
	}
	
	private SortedSet<Character> toSet(String[] lists){
		SortedSet<Character> s1 = new TreeSet<Character>();
		SortedSet<Character> s2 = new TreeSet<Character>();
		for(char c: lists[0].toCharArray()){
			s1.add(c);
		}
		for(char c: lists[1].toCharArray()){
			s2.add(c);
		}
		s1.retainAll(s2);
		return s1;
	}
	
	private int convert(SortedSet<Character> uniqueCharacters) {
		int result = 0;
		for (Iterator<Character> it= uniqueCharacters.iterator();it.hasNext();) {
			Character c = it.next();
			char c1 = c.charValue();
			int numericValue = Character.getNumericValue(c1) - 9;
			if (c1 == Character.toUpperCase(c1)) {
				numericValue += 26;
			}
			result += numericValue;
		}
		return result;
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
				int halfLength = c.length() / 2;
				String[] s = {c.substring(0, halfLength),c.substring(halfLength)};
				result.add(s);
			}
		} finally {
			if (reader != null){reader.close();}
		}
		
		return result;
	}

}
