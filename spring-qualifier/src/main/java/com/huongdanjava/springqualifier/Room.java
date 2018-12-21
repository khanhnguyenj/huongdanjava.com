package com.huongdanjava.springqualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Room {

	@Autowired
	@Qualifier("table1")
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