package com.huongdanjava.springqualifier;

public class Table {

	private String code;

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Table [code=" + code + "]";
	}

}