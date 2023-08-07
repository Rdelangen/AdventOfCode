package adventOfCode.AdventOfCode.twelve;

import java.io.IOException;
import java.util.ArrayList;

import adventOfCode.AdventOfCode.generic.LocalFileReader;
import adventOfCode.AdventOfCode.generic.ModifyFileContents;
public class AdventTwelveCore {
	
	private final int ASCII_VALUE_S = 83, ASCII_VALUE_E = 69, ASCII_VALUE_a = 97;//, ASCII_VALUE_z = 122;
	private ArrayList<Point> graph = new ArrayList<>();
	private boolean isGraphUpdated = true;
	
	// Part 1 after 1:40:00
	// Part 2 partial after 1:42:08

	public int calculateScore(ArrayList<ArrayList<Integer>> list) {
		
		for(int i=0;i<list.size();i++) {
			ArrayList<Integer> line = list.get(i);
			for (int j=0;j<line.size();j++) {
				Point p = new Point(j,i,line.get(j));
				if (line.get(j)==ASCII_VALUE_S || line.get(j) == ASCII_VALUE_a) {
					p.updateDistance(0);
				}
				graph.add(p);
			}
		}
		
		while (isGraphUpdated){
			isGraphUpdated = false;
			updateGraph(list);
		};
		
		for(int i=0;i<list.size();i++) {
			ArrayList<Integer> line = list.get(i);
			for (int j=0;j<line.size();j++) {
				if (line.get(j)==ASCII_VALUE_E) {
					return getGraphPosition(j,i,list).getDistance();
				}
//				String s = "X: " + j + " Y:" + i + " Distance: " + getGraphPosition(j,i,list).getDistance();
//				System.out.println(s);
			}
		}
		
		return 0;
	}
	
	private void updateGraph(ArrayList<ArrayList<Integer>> list) {
		int maxHeight = list.size(), maxWidth = list.get(0).size();
		for(Point p : graph) {
			int currentDistance = p.getDistance();
			int currentHeight = p.getHeight();
			if (currentDistance == Point.distanceDefault) continue;
			
			Point newP;
			
			if(p.getX()-1 >= 0){
				newP = getGraphPosition(p.getX()-1, p.getY(), list);
				updatePoint(newP, currentHeight, currentDistance);
			}
			if(p.getX()+1 < maxWidth){
				newP = getGraphPosition(p.getX()+1, p.getY(), list);
				updatePoint(newP, currentHeight, currentDistance);
			}
			if(p.getY()-1 >= 0){
				newP = getGraphPosition(p.getX(), p.getY()-1, list);
				updatePoint(newP, currentHeight, currentDistance);
			}
			if(p.getY()+1 < maxHeight){
				newP = getGraphPosition(p.getX(), p.getY()+1, list);
				updatePoint(newP, currentHeight, currentDistance);
			}
		}
	}
	
	private Point getGraphPosition(int x, int y, ArrayList<ArrayList<Integer>> list) {
		return graph.get(list.get(0).size() * y + x);
	}
	
	private void updatePoint(Point p, int currentHeight, int currentDistance) {
		if(p.getHeight()-currentHeight<=1){
			int oldDistance = p.getDistance();
			p.updateDistance(currentDistance+1);
			isGraphUpdated = isGraphUpdated || p.getDistance() != oldDistance;
		}
	}

	public ArrayList<ArrayList<Integer>> readFile(String filename) throws IOException{
		LocalFileReader fileReader = new LocalFileReader(new FileModifier());
		FileModifier modifiedFile = (FileModifier) fileReader.returnStrings(filename);
		return modifiedFile.returnString();
	}
	
	private class FileModifier implements ModifyFileContents{
		
		private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		@Override
		public void processLine(String s) {
			ArrayList<Integer> line = new ArrayList<>();
			for(char c : s.toCharArray()) {
				line.add((int) c);
			}
			result.add(line);
		}
		
		public ArrayList<ArrayList<Integer>> returnString() {	
			return result;
		}
	}
}
