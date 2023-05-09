package adventOfCode.AdventOfCode.generic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LocalFileReader {
	
	ModifyFileContents modify;
	
	public LocalFileReader(ModifyFileContents modify) {
		this.modify = modify;
	}
	
	public ArrayList<String[]> returnStrings(String filename) throws IOException{
		
		BufferedReader reader = null;
		try {
			String c;
			reader = new BufferedReader(new FileReader(filename));		
			while(true) {
				c = reader.readLine();
				if(c==null) {break;};
				modify.processLine(c);
			}
		} finally {
			if (reader != null){reader.close();}
		}
		
		return modify.getResult();
	}

}
