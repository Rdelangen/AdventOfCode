package adventOfCode.AdventOfCode.seven;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Directory implements FileSystem {
	
	private final FileSystem parent;
	private HashMap<String, FileSystem> children;
	
	public Directory(FileSystem parent) {
		this.parent = parent;
		children = new HashMap<>();
	}
	
	public void addChild(String name, FileSystem child) {
		children.putIfAbsent(name, child);
	}
	
	public FileSystem getChild(String key) {
		return children.get(key);
	}
	
	public Collection<FileSystem> getChildren() {
		return children.values();
	}

	@Override
	public FileSystem getParent() {
		return this.parent;
	}
	
	@Override
	public FileSystem getRoot() {
		FileSystem ret = this;
		while (ret.getParent() != null) {
			ret = ret.getParent();
		}
		return ret;
		
	}

	@Override
	public int getSize() {
		int size = 0;
		for( FileSystem child : children.values()) {
			size += child.getSize();
		}
		return size;
	}

}
