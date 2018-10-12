package com.example.demo;

import com.example.demo.model.Users;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test() {
//        第一次查询
        Users users = userService.findById(2);
        System.out.println(users);
//          第二次查询
        Users users2 = userService.findById(2);
        System.out.println(users);
    }

    @Test
    public void test2() {
//        第一次查询
        List<Users> all = userService.findAll();
        System.out.println(all);

        Users users = new Users();
        users.setName("网吧");
        users.setAge(255);
        userService.insterUser(users);

//          第二次查询
        List<Users> all2 = userService.findAll();
        System.out.println(all2);
    }

    /**
     * redis 测试
     */
    @Test
    public void redisTest2() {
        redisTemplate.opsForValue().set("孙晓东", "中秋快乐");
        redisTemplate.opsForValue().set("丽丽", "花花");

    }

    @Test
    public void redisTest3() {
        Object 孙晓东 = redisTemplate.opsForValue().get("孙晓东");
        Object 丽丽 = redisTemplate.opsForValue().get("丽丽");
        System.out.println(孙晓东);
        System.out.println(丽丽);
    }

    /**
     * redis 测试  存对象
     */
    @Test
    public void redisSaveObjectTest() {
        Users users = new Users();
        users.setAge(23);
        users.setName("哈哈");
        users.setId(2);
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.opsForValue().set("uu", users);

    }
    /**
     * redis 测试  存对象
     */
    @Test
    public void redisGetObjectTest() {

        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        Users uu = (Users) redisTemplate.opsForValue().get("uu");
        System.out.println(uu);

    }


    /**
     * redis 测试  Json
     */
    @Test
    public void redisSaveJsonTest() {
        Users users = new Users();
        users.setAge(23);
        users.setName("哈哈");
        users.setId(2);
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
        redisTemplate.opsForValue().set("UJSON", users);}

    /**
     * redis 测试  Json
     */
    @Test
    public void redisGetJsonTest() {

        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
        Object ujson = redisTemplate.opsForValue().get("UJSON");
        System.out.println(ujson);

    }
    }
