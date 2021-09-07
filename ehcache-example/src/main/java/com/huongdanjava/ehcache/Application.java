package com.huongdanjava.ehcache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

public class Application {

  public static void main(String[] args) {
    CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
      .build(true);

    Cache<Long, User> userCache = cacheManager.createCache("user", CacheConfigurationBuilder
      .newCacheConfigurationBuilder(
        Long.class, User.class,
        ResourcePoolsBuilder.heap(10)));

    User user = new User();
    user.setId(1L);
    user.setName("Khanh");

    userCache.put(user.getId(), user);

    Cache<Long, User> userCache1 = cacheManager.getCache("user", Long.class, User.class);
    User user1 = userCache1.get(1L);
    System.out.println(user1.getName());
  }
}
