package com.huongdanjava.redis;

import java.util.concurrent.TimeUnit;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissonExample {

  public static void main(String[] args) throws InterruptedException {
    Config config = new Config();
    config.useSingleServer()
      .setAddress("redis://localhost:6379")
      .setConnectionPoolSize(10)
      .setConnectionMinimumIdleSize(5)
      .setConnectTimeout(30000);

    RedissonClient redissonClient = Redisson.create(config);

//    redissonClient.getBucket("test").set("khanh");
//    System.out.println(redissonClient.getBucket("test").get());
//
//    redissonClient.getMap("testMap").put("a", 1);
//    redissonClient.getMap("testMap").put("b", 2);
//    redissonClient.getMap("testMap").put("c", 3);
//
//    System.out.println(redissonClient.getMap("testMap").keySet().toString());
//    System.out.println(redissonClient.getMap("testMap").values().toString());

    redissonClient.getMapCache("testMapCache").put("a", 1, 2, TimeUnit.SECONDS);

    System.out.println(redissonClient.getMapCache("testMapCache").keySet().toString());

    Thread.sleep(3000);

    System.out.println("After 2s: " + redissonClient.getMapCache("testMapCache").keySet());
  }
}
