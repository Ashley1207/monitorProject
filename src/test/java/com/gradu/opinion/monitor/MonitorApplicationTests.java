package com.gradu.opinion.monitor;

import com.gradu.opinion.monitor.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MonitorApplicationTests {

    @Resource
    TestService testService;

    @Test
    void contextLoads() {
    }

    @Test
    void getName(){
        String name = testService.getName(1);
        System.out.println("更");
        System.out.println(name);
    }


}
