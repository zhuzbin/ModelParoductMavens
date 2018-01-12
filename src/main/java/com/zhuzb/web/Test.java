package com.zhuzb.web;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) throws Exception {
        String prefix = "lbl";
        String KEY_SPLIT = ":"; //用于隔开缓存前缀与缓存键值


        ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:xml/aaaspring-redis.xml");
        JedisCluster pool =  (JedisCluster) ac.getBean("redisClient1");
        String name = pool.get("name");
        System.out.println(name);

        //pool.set("address","北京市海淀区");
        String address = pool.get("address");
        System.out.println(address);
        System.out.println("exites:"+pool.exists("address"));//测试多个报错，不在一个槽
        System.out.println(pool.ttl("age"));
        System.out.println(pool.del("address"));
/*        String result = pool.mset("{lbl:}" + "name", "张三", "{" + prefix + KEY_SPLIT + "}" + "age", "23", "{" + prefix + KEY_SPLIT + "}" + "address", "adfsa", "{" + prefix + KEY_SPLIT + "}" + "score", "100");
        System.out.println(result);*/
        List<String> mgets = pool.mget("{" + prefix + KEY_SPLIT + "}" + "name", "{" + prefix + KEY_SPLIT + "}" + "age", "{" + prefix + KEY_SPLIT + "}" + "address");
        System.out.println(mgets);
        pool.append("{lbl:}score","200");
        System.out.println(pool.get("{lbl:}score"));
        //pool.rpush("lists","v1","va2","v3");
        List<String> lists = pool.lrange("lists",0,10);
        System.out.println(lists);
        System.out.println(pool.type("lists"));
        System.out.println(pool.llen("lists"));
        //System.out.println(pool.dbSize());

        pool.sadd("order1","1023123123","234234234","34543535","","123123123123");
        pool.sadd("order1","zhuzb");
        pool.srem("order1","");
        Set<String> sets = pool.smembers("order1");
        System.out.println(sets);


        pool.zadd("score",100,"{id:111111111,name:23423424,image:ht12313123123}");
        pool.zadd("score",80,"{id:22222222,name:23423424,image:ht12313123123}");
        pool.zadd("score",90,"{id:33333333,name:23423424,image:ht12313123123}");
        pool.zadd("score",10,"{id:44444444,name:23423424,image:ht12313123123}");
        pool.zadd("score",10,"{id:555555555,name:23423424,image:ht12313123123}");
        Set<String> sset = pool.zrevrange("score",0,-1);
        System.out.println(sset);


        pool.hset("112233","name","zhuzb");
        pool.hset("112233","age","18");
        pool.hset("112233","address","北京市海淀区");
        Map<String,String> hall = pool.hgetAll("112233");
        System.out.println(hall);

        pool.close();
    }

    public void testRedis(){
/*         Jedis jedis = new Jedis("127.0.0.1",6379);
     //key
     Set<String> keys = jedis.keys("*");
     for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
       String key = (String) iterator.next();
       System.out.println(key);
     }
     System.out.println("jedis.exists====>"+jedis.exists("k2"));
     System.out.println(jedis.ttl("k1"));
     
            //String
     //jedis.append("k1","myreids");
     System.out.println(jedis.get("k1"));
     jedis.set("k4","k4_redis");
     System.out.println("----------------------------------------");
     jedis.mset("str1","v1","str2","v2","str3","v3");
     System.out.println(jedis.mget("str1","str2","str3"));
     
           //list
     System.out.println("----------------------------------------");
     //jedis.lpush("mylist","v1","v2","v3","v4","v5");
     List<String> list = jedis.lrange("mylist",0,-1);
     for (String element : list) {
       System.out.println(element);
     }

     //set
     jedis.sadd("orders","jd001");
     jedis.sadd("orders","jd002");
     jedis.sadd("orders","jd003");
     Set<String> set1 = jedis.smembers("orders");
     for (Iterator iterator = set1.iterator(); iterator.hasNext();) {
       String string = (String) iterator.next();
       System.out.println(string);
     }
     jedis.srem("orders","jd002");
     System.out.println(jedis.smembers("orders").size());


     //hash
     jedis.hset("hash1","userName","lisi");
     System.out.println(jedis.hget("hash1","userName"));
     Map<String,String> map = new HashMap<String,String>();
     map.put("telphone","13811814763");
     map.put("address","atguigu");
     map.put("email","abc@163.com");
     jedis.hmset("hash2",map);
     List<String> result = jedis.hmget("hash2", "telphone","email");
     for (String element : result) {
       System.out.println(element);
     }


     //zset
     jedis.zadd("zset01",60d,"v1");
     jedis.zadd("zset01",70d,"v2");
     jedis.zadd("zset01",80d,"v3");
     jedis.zadd("zset01",90d,"v4");
     
     Set<String> s1 = jedis.zrange("zset01",0,-1);
     for (Iterator iterator = s1.iterator(); iterator.hasNext();) {
       String string = (String) iterator.next();
       System.out.println(string);
     }*/
    }
}
