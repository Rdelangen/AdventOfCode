package adventOfCode.AdventOfCode.seven;

import java.io.IOException;

import adventOfCode.AdventOfCode.generic.LocalFileReader;
import adventOfCode.AdventOfCode.generic.ModifyFileContents;

public class AdventSevenCore {
	
	public int calculateScore(Directory root) {
		int limit =   3441553;
		int result = 43441553;
		for (FileSystem dir : root.getChildren()) {
			if (dir instanceof Directory) {
				int size = dir.getSize();
				if (size >= limit) {
					result = Math.min(result, size);
				}
				result = Math.min(result, calculateScore((Directory) dir));
			}
		}
		return result;
	}
	
	public Directory readFile(String filename) throws IOException{
		LocalFileReader fileReader = new LocalFileReader(new FileModifier());
		FileModifier modifiedFile = (FileModifier) fileReader.returnStrings(filename);
		return modifiedFile.getRoot();
	}
	
	private class FileModifier implements ModifyFileContents{
		
		private Directory result = new Directory(null);

		@Override
		public void processLine(String s) {
			String[] words = s.split(" ");
			if (words[0].equals("$")){
				processCommand(words);
			}else {
				processOutput(words);
			}
		}
		
		private void processCommand(String[] words) {
			if(!words[1].equals("cd")) {
				return;
			}
			
			result = (Directory) switch (words[2]) { 	case "/" 	-> result.getRoot();
														case ".." 	-> result.getParent();
														default 	-> result.getChild(words[2]);
			};
		}
		
		private void processOutput(String[] words) {
			if (words[0].equals("dir")) {
				result.addChild(words[1], new Directory(result));
			}
			try {
			   int i = Integer.parseInt(words[0]);
			   result.addChild(words[1], new File(result, i));
			} catch (NumberFormatException e) {
			}
			
		}

		public Directory getRoot() {
			return (Directory) result.getRoot();
		}
		
	}
	
}
