package adventOfCode.AdventOfCode.twelve;

public class Point {
	
	static final int distanceDefault = 999999;
	private final int ASCII_VALUE_S = 83, ASCII_VALUE_E = 69, ASCII_VALUE_a = 97, ASCII_VALUE_z = 122;
	
	private int x,y, height;
	private int distance = distanceDefault;
	
	public Point(int x, int y, int height) {
		this.x = x;
		this.y = y;
		this.height = height;
	}
	
	public void updateDistance(int newDistance) {
		distance = Math.min(distance, newDistance);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDistance() {
		return distance;
	}

	public int getHeight() {
		return height==ASCII_VALUE_S ? ASCII_VALUE_a :
			    height==ASCII_VALUE_E ? ASCII_VALUE_z :
				height;
	}
}
