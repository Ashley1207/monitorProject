package com.gradu.opinion.monitor.web;

import com.gradu.opinion.monitor.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Author: Ashley Zhang
 * @Date: 2021/11/11 10:40 上午
 */

@Controller
@RequestMapping("/test")
public class TestController {

    @Resource
    TestService testService;

    @GetMapping("/name")
    public String getName(){
        String name = testService.getName(1);
        System.out.println(name);
        return name;
    }

}
