package adventOfCode.AdventOfCode.eight;

import java.io.IOException;
import java.util.ArrayList;
import adventOfCode.AdventOfCode.generic.LocalFileReader;
import adventOfCode.AdventOfCode.generic.ModifyFileContents;

public class AdventEightCore2 {
	
	public int calculateScore(ArrayList<ArrayList<Integer>> trees) {
		int height =trees.size(), width = trees.get(0).size();
		int maxScenicScore = 0;
		for(int i = 0;i<height;i++) {
			for(int j=0;j<width;j++) {
				Point p = new Point(i,j);
				for(Direction d : Direction.values()) {
					p.setDirection(getVisibilty(i, j, d, trees), d);
				}
//				points.add(p);
				int scenicScore = p.getScenicScore();
				maxScenicScore = Math.max(maxScenicScore, scenicScore);
			}
		}
		return maxScenicScore;
	}
	
	private int getVisibilty(int x, int y, Direction direction, ArrayList<ArrayList<Integer>> trees) {
		int height =trees.size(), width = trees.get(0).size();
		int treeHeight = trees.get(x).get(y);
		int amountOfVisibleTrees = 0;
		switch (direction){
			case NORTH:
				for(int i = x-1; i>=0;i--) {
					amountOfVisibleTrees++;
					int neigbourHeight = trees.get(i).get(y);
					if (neigbourHeight >= treeHeight){
						break;
					}
				}
				break;
			case EAST:
				for(int i = y+1; i<width;i++) {
					amountOfVisibleTrees++;
					int neigbourHeight = trees.get(x).get(i);
					if (neigbourHeight >= treeHeight){
						break;
					}
				}
				break;
			case SOUTH:
				for(int i = x+1; i<height;i++) {
					amountOfVisibleTrees++;
					int neigbourHeight = trees.get(i).get(y);
					if (neigbourHeight >= treeHeight){
						break;
					}
				}
				break;
			case WEST:
				for(int i = y-1; i>=0;i--) {
					amountOfVisibleTrees++;
					int neigbourHeight = trees.get(x).get(i);
					if (neigbourHeight >= treeHeight){
						break;
					}
				}
				break;
			default:
				return 0;
		}
		
		return amountOfVisibleTrees;
	}
	
	public ArrayList<ArrayList<Integer>> readFile(String filename) throws IOException{
		LocalFileReader fileReader = new LocalFileReader(new FileModifier());
		FileModifier modifiedFile = (FileModifier) fileReader.returnStrings(filename);
		return modifiedFile.returnString();
	}
	
	private class FileModifier implements ModifyFileContents{
		
		private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		@Override
		public void processLine(String s) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(char c : s.toCharArray()) {
				list.add(Integer.parseInt(String.valueOf(c)));
			}
			result.add(list);
		}	
		
		public ArrayList<ArrayList<Integer>> returnString() {	
			return result;
		}
	}

}
