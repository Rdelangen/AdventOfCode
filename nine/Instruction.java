package adventOfCode.AdventOfCode.nine;

public class Instruction {
	private Direction d;
	private int magnitude;
	
	public Instruction(Direction d, int magnitude) {
		this.d = d;
		this.magnitude = magnitude;
	}
	
	public Direction getDirection() {
		return d;
	}
	
	public int getMagnitude() {
		return magnitude;
	}
}
