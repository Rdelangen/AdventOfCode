package adventOfCode.AdventOfCode.two;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AdventTwoCore {
	
	public int calculateScore(ArrayList<String[]> book) {
		return book.stream().map(this::convert).map(this::convertToInt).reduce(0, Integer::sum);
	}
	
	public int calculateScoreV2(ArrayList<String[]> book) {
		return book.stream().map(this::convertWithWinLose).map(this::convertToInt).reduce(0, Integer::sum);
	}
	
	private Choice[] convert(String s[]) {
		Choice[] res = { 
				switch(s[0].toUpperCase()) { 
					case "A" -> Choice.ROCK;
					case "B" -> Choice.PAPER;
					case "C" -> Choice.SCICCOR;
					default  -> null; },
				switch(s[1].toUpperCase()) { 
					case "X" -> Choice.ROCK;
					case "Y" -> Choice.PAPER;
					case "Z" -> Choice.SCICCOR;
					default  -> null; }};
		return res;
	}
	
	private Choice[] convertWithWinLose(String s[]) {
		Choice opponentChoice = switch(s[0].toUpperCase()) { 
							case "A" -> Choice.ROCK;
							case "B" -> Choice.PAPER;
							case "C" -> Choice.SCICCOR;
							default  -> null; };
		Choice[] res = { opponentChoice, convertChoice(opponentChoice, s[1].toUpperCase())};
		return res;
	}
	
	private Choice convertChoice(Choice c, String s) {
		return switch(s) {  case "X" -> c.getBeats();
							case "Y" -> c;
							case "Z" -> c.getBeatenBy();
							default -> null;};
	}
	
	private int convertToInt(Choice s[]) {
		int result = switch(s[1]) { 
			case ROCK -> 1;
			case PAPER -> 2;
			case SCICCOR -> 3;
			default  -> 0; };
			
		result += calculateVictory(s[0], s[1]);
		return result;
	}
	
	
	private int calculateVictory(Choice s1, Choice s2) {
		if (s1 == s2){ return 3;}
		if (s1.getBeatenBy() == s2){ return 6;}
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
