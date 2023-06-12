package adventOfCode.AdventOfCode.seven;

public class File implements FileSystem {
	
	private FileSystem parent;
	private int size;
	
	public File(FileSystem parent, int size) {
		this.parent = parent;
		this.size = size;
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
		return this.size;
	}

}
