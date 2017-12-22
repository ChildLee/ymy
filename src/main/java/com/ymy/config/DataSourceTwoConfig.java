package com.ymy.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 副数据源
 */
@Configuration
@MapperScan(basePackages = {"com.ymy.mapperTwo"}, sqlSessionFactoryRef = "sqlSessionFactoryTwo")
public class DataSourceTwoConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid.two")
    public DataSource dataSourceTwo() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryTwo() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSourceTwo());
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateTwo() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryTwo());
        return template;
    }
}
