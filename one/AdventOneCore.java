package adventOfCode.AdventOfCode.one;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class AdventOneCore {
	
	public ArrayList<Integer> getIntegerList(String filename) throws IOException{
		
		ArrayList<Integer> integerList = new ArrayList<>();
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(filename));
			
			Integer n = 0;
			
			String c = reader.readLine();
			while (c != null) {
				
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
		
		Collections.sort(integerList, Collections.reverseOrder());
		return integerList;
	}
	
}
