package com.gradu.opinion.monitor.config.service;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.SQLException;

/**
 * @Author: Ashley Zhang
 * @Date: 2021/11/11 11:20 上午
 */
public class PublicDataSourceConfig {
    public static DruidDataSource generateCommonDataSource(PublicConfigPropertied config, String username,
                                                           String password, String url) throws SQLException {
        DruidDataSource druid=new DruidDataSource();
        druid.setFilters(config.getFilters());

        druid.setDriverClassName(config.getDriverClassName());

        druid.setInitialSize(config.getInitialSize());
        druid.setMaxActive(config.getMaxActive());
        druid.setMinIdle(config.getMinIdle());
        druid.setMaxWait(config.getMaxWait());
        druid.setTimeBetweenConnectErrorMillis(config.getTimeBetweenEvictionRunsMillis());
        druid.setValidationQuery(config.getValidationQuery());
        druid.setTestWhileIdle(config.isTestWhileIdle());
        druid.setTestOnBorrow(config.isTestOnBorrow());
        druid.setTestOnReturn(config.isTestOnReturn());
        druid.setPoolPreparedStatements(config.isPoolPreparedStatements());
        druid.setMaxPoolPreparedStatementPerConnectionSize(config.getMaxPoolPreparedStatementPerConnectionSize());
        druid.setUsername(username);
        druid.setPassword(password);
        druid.setUrl(url);
        return druid;
    }

}
