package com.xd.rabbirmq;

import com.xd.rabbirmq.te.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbirmqApplicationTests {


    @Autowired
    private Sender sender;

    @Test
    public void contextLoads() throws Exception {
        while (true) {
            Thread.sleep(1000);
            sender.send("hello 第一个消息");
        }
    }

}
