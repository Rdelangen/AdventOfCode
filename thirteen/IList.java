package adventOfCode.AdventOfCode.thirteen;

import java.util.ArrayList;

public interface IList extends Comparable<IList>{
	@Override
	public int compareTo(IList right);
	public ArrayList<IList> getList();
	public int getSize();
}
