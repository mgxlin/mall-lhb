package com.lhb.mall.service;

/**
 * @author lhb
 * @date 2022/1/16 20:14
 */
public interface RedisService {
    /**
     * 存储数据
     */
    void set(String key, String value);

    /**
     * 取数据
     */
    String get(String key);

    /**
     * 设置过期时间
     */
    void expire(String key, long expire);

    /**
     * 删除数据
     */
    void remove(String key);

    /**
     * 自增操作
     */
    void increment(String key, long delta);
}
