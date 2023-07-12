package adventOfCode.AdventOfCode.eleven;

import java.util.ArrayList;
import java.util.LinkedList;

public class Monkey {
	
	public LinkedList<Long> items;
	public int testValue, monkeyTrue, monkeyFalse;
	public int plusOperator, timesOperator, squareOperator;
	public int amountOfItems;
	
	public Monkey(int testValue, int monkeyTrue, int monkeyFalse, int times, int plus, int square) {
		this.testValue = testValue;
		this.monkeyTrue = monkeyTrue;
		this.monkeyFalse = monkeyFalse;
		this.plusOperator = plus;
		this.timesOperator = times;
		this.squareOperator = square;
		this.amountOfItems = 0;
		this.items = new LinkedList<>();
	}
	
	public long newWorry(long oldWorry) {
		if (squareOperator != 0) {
			return oldWorry*oldWorry;
		}
		return oldWorry * timesOperator + plusOperator;
//		return operation.newWorry(oldWorry);
	}
	
	public void passToMonkey(ArrayList<Monkey> monkeys) {
		while(!items.isEmpty()) {
			Long item = items.pop();
			item = item % 9699690;
			item = newWorry(item);
			Monkey newMonkey = monkeys.get(test(item));
			newMonkey.addItem(item);
			amountOfItems++;
		}
		
	}
	
	private int test(long oldWorry) {
		return oldWorry%testValue==0 ? monkeyTrue : monkeyFalse;
	}
	
	public void addItem(long item) {
		items.add(item);
	}

}
