package adventOfCode.AdventOfCode.four;

public class AdventFourCoreV2 extends AdventFourCore {
	
	@Override
	protected boolean filter(int[] i) {
		return between(i[0], i[2], i[3]) || between(i[1], i[2], i[3])
			|| between(i[2], i[0], i[1]) || between(i[3], i[0], i[1]);
	}
	
	private boolean between(int i, int low, int high) {
		return low <= i && i <= high;
	}
}
