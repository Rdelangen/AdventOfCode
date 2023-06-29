package adventOfCode.AdventOfCode.eight;

public class Point{
	private int x,y;
	private int north,east,south, west;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setDirection(int visibilty, Direction direction) {
		switch (direction){
		case NORTH:
			north = visibilty;
			break;
		case EAST:
			east = visibilty;
			break;
		case SOUTH:
			south = visibilty;
			break;
		case WEST:
			west = visibilty;
			break;
		default:
			break;
		}
	}
	
	public int getScenicScore() {
		return north*east*south*west;
	}
	
	@Override
	public boolean equals(Object o) {
		return (o instanceof Point && this.x == ((Point) o).getX() && this.y == ((Point) o).getY());
	}
	
	@Override
	public int hashCode() {
//	    final int prime = 31;
//	    int result = 1;
//	    result = prime * result + x;
//	    result = prime * result + y;
//	    return result;
		return x;
	}
	
	@Override
	public String toString() {
		return "x: " + x + " y: " + y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
