package com.ymy.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DruidConfig {

    @Value("${spring.datasource.driver-class-name:com.mysql.cj.jdbc.Driver}")
    private String driverClassName;

    @Value("${spring.datasource.url:jdbc:mysql://prosperous.mysql.rds.aliyuncs.com/ymy}")
    private String jdbcUrl;

    @Value("${spring.datasource.connectionProperties:useSSL=true}")
    private String connectionProperties;

    @Value("${spring.datasource.username:root}")
    private String username;

    @Value("${spring.datasource.password:}")
    private String password;

    @Value("${spring.datasource.initialSize:5}")
    private int initialSize;

    @Value("${spring.datasource.minIdle:5}")
    private int minIdle;

    @Value("${spring.datasource.maxActive:20}")
    private int maxActive;

    @Value("${spring.datasource.maxWait:60000}")
    private int maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis:60000}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.validationQuery:SELECT 1}")
    private String validationQuery;

    @Value("${spring.datasource.filters:stat,wall,log4j2}")
    private String filters;


    @Bean
    public DataSource druidDataSource() {
        //配置数据源
        DruidDataSource datasource = new DruidDataSource();
        //驱动程序类名称
        datasource.setDriverClassName(driverClassName);
        //连接数据库的url
        datasource.setUrl(jdbcUrl);
        //连接参数
        datasource.setConnectionProperties(connectionProperties);
        //数据库账号
        datasource.setUsername(username);
        //数据库密码
        datasource.setPassword(password);
        //初始化连接大小
        datasource.setInitialSize(initialSize);
        //最小连接池数量
        datasource.setMinIdle(minIdle);
        //最大连接池数量
        datasource.setMaxActive(maxActive);
        //获取连接时最大等待时间
        datasource.setMaxWait(maxWait);
        //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        //验证连接是否成功, SQL SELECT 指令至少要返回一行  (测试/验证连接池连接的SQL语句也因数据库而异)
        datasource.setValidationQuery(validationQuery);
        try {
            //配置监控统计拦截的filters 去掉后监控界面sql无法统计,开启web监控、开启sql防火墙
            datasource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datasource;
    }

    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");
        reg.addInitParameter("loginUsername", username);
        reg.addInitParameter("loginPassword", password);
        return reg;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        return filterRegistrationBean;
    }
}
