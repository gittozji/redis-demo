
package me.zji.redisdemo.service.impl;

import me.zji.redisdemo.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 其他类型的操作
 *
 * @author zhanzj19285
 * @date 2019/10/31
 */
@Service
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void example() {
        // hash
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("hash::01", "name", "名称");
        hashOperations.put("hash::01", "age", 20);
        // 设置过期时间
        redisTemplate.expire("hash::01", 10, TimeUnit.SECONDS);
        System.out.println(hashOperations.get("hash::01", "name"));
        System.out.println(hashOperations.get("hash::01", "age"));

        // set
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add("set::01", "你好A");
        setOperations.add("set::01", "你好A");
        setOperations.add("set::01", "你好B");
        // 设置过期时间
        redisTemplate.expire("set::01", 10, TimeUnit.SECONDS);
        System.out.println(setOperations.members("set::01"));

        // list
    }
}