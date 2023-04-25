package adventOfCode.AdventOfCode.one;

import java.io.IOException;
import java.util.ArrayList;

public class AdventOne {

	public static void main(String[] args) throws IOException{
		
		String filename = "C:\\Users\\ronald.delangen\\eclipse-workspace\\JAVA_Tutorial\\src\\adventOfCode\\AdventOfCode\\one\\Test.txt";
		
		AdventOneCore core = new AdventOneCore();
		ArrayList<Integer> integerList = core.getIntegerList(filename);
		
		for(Integer i:integerList) {
			System.out.println(i);
		}
	}
}
