package adventOfCode.AdventOfCode.two;

public enum Choice {
	ROCK,
	PAPER,
	SCICCOR;
	
	private Choice beatenBy, beats;
	
	static {
		ROCK.beatenBy = PAPER;
		PAPER.beatenBy = SCICCOR;
		SCICCOR.beatenBy = ROCK;
	}
	static {
		ROCK.beats = SCICCOR;
		PAPER.beats = ROCK;
		SCICCOR.beats = PAPER;
	}
	
	public Choice getBeatenBy() {
		return beatenBy;
	}
	
	public Choice getBeats() {
		return beats;
	}
}
