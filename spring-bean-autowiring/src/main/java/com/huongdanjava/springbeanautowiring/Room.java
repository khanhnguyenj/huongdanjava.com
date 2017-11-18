package com.huongdanjava.springbeanautowiring;

public class Room {

	private Table table;

	public Room() {
	}

	public Room(Table table) {
		this.table = table;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

}