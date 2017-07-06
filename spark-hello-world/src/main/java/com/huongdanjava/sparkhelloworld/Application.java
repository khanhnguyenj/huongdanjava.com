package com.huongdanjava.sparkhelloworld;

import static spark.Spark.get;

public class Application {

	public static void main(String[] args) {
		get("/helloworld", (req, res) -> "Hello World from Spark");
	}

}
