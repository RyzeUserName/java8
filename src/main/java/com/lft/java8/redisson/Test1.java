package com.lft.java8.redisson;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;

/**
 * 描述
 * @author Ryze
 * @date 2020-05-26 17:01
 */
public class Test1 {
    public static void main(String[] args) {
        Config config = new Config();
        ClusterServersConfig clusterServersConfig = config.useClusterServers();
        clusterServersConfig.addNodeAddress("redis://192.168.0.78:6379");
        clusterServersConfig.setPassword("zhtdev$123456");
        RedissonClient redissonClient = Redisson.create(config);
        RLock lock = redissonClient.getLock("anyLock");
        // 最常见的使用方法
        lock.lock();
        System.out.println("1111");
        System.out.println("1111");
        lock.unlock();
    }
}
