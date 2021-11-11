package com.gradu.opinion.monitor.config.service;

import lombok.Data;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Author: Ashley Zhang
 * @Date: 2021/11/11 11:14 上午
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.monitor")
@MapperScan(basePackages = MonitorConfig.PACKAGE,sqlSessionFactoryRef = "monitorSqlSessionFactory")
public class MonitorConfig {
    static final String PACKAGE ="com.gradu.opinion.monitor.mapper";
    private static final String MAPPER_LOCATION="classpath:mapper/*.xml";

    private String url;
    private String username;
    private String password;

    @Resource
    PublicConfigPropertied config;

    @Bean(name = "monitorDataSource")
    public DataSource autorenewDataSource() throws SQLException {
        return PublicDataSourceConfig.generateCommonDataSource(config, username, password, url);
    }

    @Bean(name = "monitorTransactionManager")
    public DataSourceTransactionManager monitorTransactionManager() throws SQLException {
        return new DataSourceTransactionManager(autorenewDataSource());
    }

    @Bean(name = "monitorSqlSessionFactory")
    public SqlSessionFactory monitorSqlSessionFactory(@Qualifier("monitorDataSource") DataSource monitorDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(monitorDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MonitorConfig.MAPPER_LOCATION));
        sessionFactory.setTypeAliasesPackage("com.gradu.opinion.monitor.model");
        sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver()
                .getResource("classpath:sql-map-config.xml"));

        return sessionFactory.getObject();
    }


}
