package adventOfCode.AdventOfCode.five;

import java.util.ArrayList;
import java.util.Stack;

public class AdventFiveCoreV2 extends AdventFiveCore {
	
	@Override
	protected void moveBlock(ArrayList<Stack<String>> block, String[] instruction) {
		int numberOfBlocks = Integer.parseInt(instruction[1]);
		int from = Integer.parseInt(instruction[3]);
		int to = Integer.parseInt(instruction[5]);
		
		Stack<String> towerFrom = block.get(from - 1);
		Stack<String> towerTo = block.get(to - 1);
		
		String value = "";
		for(int i = 0;i<numberOfBlocks;i++) {
			value += towerFrom.pop();
		}
		for(int i=numberOfBlocks;i>0;i--) {
			towerTo.push(value.substring(i-1,i));
		}
	}
}
