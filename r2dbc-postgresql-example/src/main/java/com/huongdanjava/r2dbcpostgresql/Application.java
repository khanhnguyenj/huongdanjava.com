package com.huongdanjava.r2dbcpostgresql;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.Result;
import reactor.core.publisher.Flux;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		ConnectionFactory connectionFactory = ConnectionFactories
		    .get("r2dbc:postgresql://khanh:123456@localhost:5432/test");

		Flux.from(connectionFactory.create())
			.flatMap(connection -> connection.createStatement("INSERT INTO student (name, address) VALUES ($1, $2)")
	    		.bind("$1", "khanh")
	    		.bind("$2", "Ho Chi Minh")
	    		.execute())
			.flatMap(Result::getRowsUpdated)
			.doOnNext(s -> System.out.println(s))
			.subscribe();

		Thread.sleep(5000);
	}

}
