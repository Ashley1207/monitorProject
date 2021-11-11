package com.gradu.opinion.monitor.mapper;

import com.gradu.opinion.monitor.model.TestInfo;


public interface TestInfoMapper {
    String selectId(Integer id);

    int insert(TestInfo record);

    int insertSelective(TestInfo record);
}