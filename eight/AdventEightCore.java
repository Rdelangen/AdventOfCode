package adventOfCode.AdventOfCode.eight;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import adventOfCode.AdventOfCode.generic.LocalFileReader;
import adventOfCode.AdventOfCode.generic.ModifyFileContents;

public class AdventEightCore {
	
	public int calculateScore(ArrayList<ArrayList<Integer>> trees) {
		HashSet<Point> visibleTrees = new HashSet<Point>();
		int height =trees.size(), width = trees.get(0).size();
		for(int i=0;i<height;i++) {
			int maxHeight = -1;
			for(int j=0;j<width;j++) {
				int treeHeight = trees.get(i).get(j);
				if (treeHeight > maxHeight) {
					maxHeight = treeHeight;
					visibleTrees.add(new Point(i,j));
				}
			}
			
			maxHeight = -1;
			for(int j=width-1;j>=0;j--) {
				int treeHeight = trees.get(i).get(j);
				if (treeHeight > maxHeight) {
					maxHeight = treeHeight;
					visibleTrees.add(new Point(i,j));
				}
			}
		}
					
		for(int j=0;j<width;j++) {
			int maxHeight = -1;
			for(int i=0;i<height;i++) {
				int treeHeight = trees.get(i).get(j);
				if (treeHeight > maxHeight) {
					maxHeight = treeHeight;
					visibleTrees.add(new Point(i,j));
				}
			}
			
			maxHeight = -1;
			for(int i=height-1;i>=0;i--) {
				int treeHeight = trees.get(i).get(j);
				if (treeHeight > maxHeight) {
					maxHeight = treeHeight;
					visibleTrees.add(new Point(i,j));
				}
			}
		}
		
		return visibleTrees.size();
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
