package adventOfCode.AdventOfCode.thirteen;

import java.util.ArrayList;

public class AList implements IList{
	
	ArrayList<IList> list;
	
	public AList() {
		list = new ArrayList<IList>();
	}

	public void addElement(IList l) {
		getList().add(l);
	}

	public ArrayList<IList> getList() {
		return list;
	}
	
	public int getSize() {
		return getList().size();
	}

	@Override
	public int compareTo(IList right) {
		
		int i = 0;
		while(true) {
			
			if (i>=getSize()) {
				return getSize() == right.getSize()? 0 : -1;
			}
			
			if (i>=right.getSize()) {
				return 1;
			}
			
			IList leftValue = getList().get(i);
			IList rightValue = right.getList().get(i);
			
			int compareValue = leftValue.compareTo(rightValue);
			if(compareValue != 0) {
				return compareValue;
			};
			
			i++;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");
		for(IList element : list) {
			s.append(element + ",");
		}
		s.append("]");
		return s.toString();
	}
}
