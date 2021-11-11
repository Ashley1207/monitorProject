package com.gradu.opinion.monitor.service;

import com.gradu.opinion.monitor.mapper.TestInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Ashley Zhang
 * @Date: 2021/11/11 10:36 上午
 */
@Service
public class TestServiceImpl implements TestService{
    @Resource
    TestInfoMapper testInfoMapper;


    @Override
    public String getName(Integer id) {
        return testInfoMapper.selectId(id);
    }
}
