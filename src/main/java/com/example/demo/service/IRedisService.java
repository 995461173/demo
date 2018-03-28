package com.example.demo.service;

import java.util.List;
import java.util.Set;

public interface IRedisService {

    boolean set(String key, String value);

    boolean setNX(String key, String value);

    String get(String key);

    boolean expire(String key, long expire);

    <T> boolean setList(String key, List<T> list);

    <T> List<T> getList(String key, Class<T> clz);

    long lpush(String key, Object obj);

    long rpush(String key, Object obj);

    String lpop(String key);

    boolean hset(String key, Set<String> set);

    boolean del(String key);

    boolean ltrim(String key, int start, int end);

    List<byte[]> getListRange(String key, long start, long end);

    long ttl(String key);
}
