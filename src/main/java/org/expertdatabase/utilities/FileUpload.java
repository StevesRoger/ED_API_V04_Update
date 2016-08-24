package org.expertdatabase.utilities;

public class FileUpload {

	private byte[] bytes;
	
	private String file;

	private String key;
	
	private String dir;
	
	public FileUpload() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FileUpload(byte[] bytes, String file,String key) {
		super();
		this.bytes = bytes;
		this.file = file;
		this.key=key;
	}
	
	public FileUpload(byte[] bytes, String file, String key, String dir) {
		super();
		this.bytes = bytes;
		this.file = file;
		this.key = key;
		this.dir = dir;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
			
}
