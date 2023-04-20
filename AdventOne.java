package adventOne;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AdventOne {

	public static void main(String[] args) throws IOException{
		
		ArrayList<Integer> integerList = new ArrayList<>();
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("C:\\Users\\ronald.delangen\\eclipse-workspace\\JAVA_Tutorial\\src\\adventOne\\Test.txt"));
			
			Integer n = 0;
			
			String c = reader.readLine();
			while (c != null) {
				System.out.println(c);
				
				if (c.equals("")) {
					integerList.add(n);
					n = 0;
				}else {
					n = n + Integer.parseInt(c);
				}
				c = reader.readLine();
			}
			integerList.add(n);
		} finally {
			if (reader != null){
				reader.close();
			}
		}
		
		System.out.println("\n");
		
		for(Integer i:integerList) {
			System.out.println(i);
		}
	}
}
