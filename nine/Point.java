package adventOfCode.AdventOfCode.nine;

public class Point{
	private int x,y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	
	@Override
	public boolean equals(Object o) {
		return (o instanceof Point && this.x == ((Point) o).getX() && this.y == ((Point) o).getY());
	}
	
	@Override
	public int hashCode() {
		return x;
	}
	
	@Override
	public String toString() {
		return "x: " + x + " y: " + y + "\n";
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
