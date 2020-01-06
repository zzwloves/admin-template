package io.vicp.wloves.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author zhuzw
 * @version <b>1.0.0</b>
 * @date 2019/10/26 11:02
 */
@Slf4j
@Configuration
public class DataBaseConfig {

    @Autowired
    DataBaseProperties dataBaseProperties;

    @Bean
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(dataBaseProperties.getUrl());
        datasource.setUsername(dataBaseProperties.getUsername());
        datasource.setPassword(dataBaseProperties.getPassword());
        datasource.setDriverClassName(dataBaseProperties.getDriverClassName());

        // configuration
        datasource.setInitialSize(dataBaseProperties.getInitialSize());
        datasource.setMinIdle(dataBaseProperties.getMinIdle());
        datasource.setMaxActive(dataBaseProperties.getMaxActive());
        datasource.setMaxWait(dataBaseProperties.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(dataBaseProperties.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(dataBaseProperties.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(dataBaseProperties.getValidationQuery());
        datasource.setTestWhileIdle(dataBaseProperties.getTestWhileIdle());
        datasource.setTestOnBorrow(dataBaseProperties.getTestOnBorrow());
        datasource.setTestOnReturn(dataBaseProperties.getTestOnReturn());
        datasource.setPoolPreparedStatements(dataBaseProperties.getPoolPreparedStatements());
        datasource.setMaxPoolPreparedStatementPerConnectionSize(dataBaseProperties.getMaxPoolPreparedStatementPerConnectionSize());
        try {
            datasource.setFilters(dataBaseProperties.getFilters());
        } catch (SQLException e) {
            log.error("druid configuration initialization filter", e);
        }
        datasource.setConnectionProperties(dataBaseProperties.getConnectionProperties());
        return datasource;
    }

}
