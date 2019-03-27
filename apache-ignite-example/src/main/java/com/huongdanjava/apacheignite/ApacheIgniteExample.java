package com.huongdanjava.apacheignite;

import org.apache.ignite.Ignition;
import org.apache.ignite.client.ClientCache;
import org.apache.ignite.client.ClientException;
import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.configuration.ClientConfiguration;

public class ApacheIgniteExample {

	public static void main(String[] args) throws ClientException, Exception {
		ClientConfiguration cfg = new ClientConfiguration();
		cfg.setAddresses("localhost:10800");

		try (IgniteClient igniteClient = Ignition.startClient(cfg)) {
			ClientCache<Integer, String> clientCache = igniteClient.getOrCreateCache("huongdanjava");

			clientCache.put(1, "Hello");
			clientCache.put(2, "Huong Dan Java");

			ClientCache<Object, Object> cache = igniteClient.cache("huongdanjava");

			System.out.println(String.format("%s, %s", cache.get(1), cache.get(2)));
		}
	}
}
