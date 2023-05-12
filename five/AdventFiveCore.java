package adventOfCode.AdventOfCode.five;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class AdventFiveCore {
	
	public class fileContents {
		ArrayList<Stack<String>> blocks;
		ArrayList<String[]> instructions;
	}
	
	public String getFirstBlocks(fileContents fileContent) {
		String resultString = "";
		for(String[] instruction : fileContent.instructions) {
			moveBlock(fileContent.blocks, instruction);
		}
		for(Stack<String> tower : fileContent.blocks) {
			resultString += tower.pop();
		}
		return resultString;
	}
	
	protected void moveBlock(ArrayList<Stack<String>> block, String[] instruction) {
		int numberOfBlocks = Integer.parseInt(instruction[1]);
		int from = Integer.parseInt(instruction[3]);
		int to = Integer.parseInt(instruction[5]);
		
		Stack<String> towerFrom = block.get(from - 1);
		Stack<String> towerTo = block.get(to - 1);
		
		for(int i = 0;i<numberOfBlocks;i++) {
			String value = towerFrom.pop();
			towerTo.push(value);
		}
	}
	
	public fileContents readFile(String filename) throws IOException{
		fileContents result = new fileContents();
		result.blocks = new ArrayList<Stack<String>>();
		result.instructions = new ArrayList<String[]>();
		
		BufferedReader reader = null;
		try {
			String c;
			boolean isOnInstructions = false;
			reader = new BufferedReader(new FileReader(filename));	
			
			while(true) {
				c = reader.readLine();
				if(c==null) {break;};
				
				if(c.isBlank()) {
					isOnInstructions = true;
					continue;
				};
				
				// De regel met torennummer verwijderen We hebben dit niet nodig
				String noWhitespace = c.replaceAll("\\s", "");
				if(noWhitespace.charAt(0)=='1') {
					continue;
				}
				
				if (!isOnInstructions) {
					int length = (c.length() + 1) / 4;
					while(result.blocks.size() < length ) {
						result.blocks.add(new Stack<String>());
					}
					char[] chars = new char[c.length()];
					c.getChars(0, c.length(), chars, 0);
					
					for(int i=1;i<c.length();i+= 4) {
						if(chars[i]==' ') continue;
						Stack<String> stack = result.blocks.get((int)((i-1)/4));
						stack.add(0,String.copyValueOf(chars, i, 1));
					}
				} else {
					result.instructions.add(c.split(" "));
				}
				
			}
		} finally {
			if (reader != null){reader.close();}
		}
		
		return result;
	}
}
