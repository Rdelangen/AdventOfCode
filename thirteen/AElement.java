package adventOfCode.AdventOfCode.thirteen;

import java.util.ArrayList;

public class AElement implements IList {

	private int value;
	public AElement(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	public int compareTo(IList right) {
		if (right instanceof AElement) {
			return value - ((AElement) right).getValue();
		}
		
		if (right instanceof AList) {
			AList leftList = new AList();
			leftList.addElement(this);
			return leftList.compareTo(right);
		}
		return 0;
	}

	@Override
	public ArrayList<IList> getList() {
		ArrayList<IList> list = new ArrayList<IList>();
		list.add(this);
		return list;
	}

	@Override
	public int getSize() {
		return 1;
	}
	
	@Override
	public String toString() {
		return Integer.toString(value);
	}

}
