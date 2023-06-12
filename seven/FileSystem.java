package adventOfCode.AdventOfCode.seven;

public interface FileSystem {
	FileSystem getParent();
	FileSystem getRoot();
	int getSize();
}
