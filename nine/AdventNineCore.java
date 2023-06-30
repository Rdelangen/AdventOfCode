package adventOfCode.AdventOfCode.nine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import adventOfCode.AdventOfCode.generic.LocalFileReader;
import adventOfCode.AdventOfCode.generic.ModifyFileContents;

public class AdventNineCore {
	
	public int calculateScore(ArrayList<Instruction> list) {
		HashSet<Point> visitedLocations = new HashSet<Point>();
		
		int ropeLength = 10;
		ArrayList<int[]> positions = new ArrayList<>();
		for(int i=0;i<ropeLength;i++) {
			int[] pos = new int[2];
			pos[0] = 0;pos[1]=0;
			positions.add(pos);
		}
		
		visitedLocations.add(new Point(0,0));
		for(Instruction instruction : list) {
			int magnitude = instruction.getMagnitude();
			while (magnitude > 0) {
				magnitude--;
				int[] tail = {0,0}, head = {0,0}, oldHead = {0,0};
				head = positions.get(0);
				oldHead = head.clone();
				switch (instruction.getDirection()) {
				case UP:
					head[1]++;
					break;
				case RIGHT:
					head[0]++;
					break;
				case DOWN:
					head[1]--;
					break;
				case LEFT:
					head[0]--;
					break;
				default:
					break;
				}
				for(int i=1;i<positions.size();i++) {
					tail = positions.get(i);
					head = positions.get(i-1);
					positions.set(i, updateTail(head, tail));
				}
				tail = positions.get(9);
				visitedLocations.add(new Point(tail[0], tail[1]));
			}
		}
		return visitedLocations.size();
	}
	
	private int[] updateTail(int[] head, int[] tail) {
		int [] result = tail;
		if (Math.abs(tail[0] - head[0]) > 1 || Math.abs(tail[1] - head[1]) > 1) {
			if(head[0] > tail[0]) {
				result[0]++;
			} else if (head[0] < tail[0]) {
				result[0]--;
			};
			if(head[1] > tail[1]) {
				result[1]++;
			} else if(head[1] < tail[1]) {
				result[1]--;
			}
		};
		return result;
	}
	
	public ArrayList<Instruction> readFile(String filename) throws IOException{
		LocalFileReader fileReader = new LocalFileReader(new FileModifier());
		FileModifier modifiedFile = (FileModifier) fileReader.returnStrings(filename);
		return modifiedFile.returnString();
	}
	
	private class FileModifier implements ModifyFileContents{
		
		private ArrayList<Instruction> result = new ArrayList<>();

		@Override
		public void processLine(String s) {
			String[] chars = s.split(" ");
			result.add(new Instruction(switch (chars[0]) {
			case "U" -> Direction.UP;
			case "R" -> Direction.RIGHT;
			case "D" -> Direction.DOWN;
			case "L" -> Direction.LEFT;
			default -> Direction.UP;
			}, Integer.parseInt(chars[1])));
		}	
		
		public ArrayList<Instruction> returnString() {	
			return result;
		}
	}

}
