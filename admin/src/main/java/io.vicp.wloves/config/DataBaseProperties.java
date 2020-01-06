package io.vicp.wloves.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhuzw
 * @version <b>1.0.0</b>
 * @date 2019/10/26 11:02
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class DataBaseProperties {
    private String url;

    private String username;

    private String password;

    private String driverClassName;

    private Integer initialSize;

    private Integer minIdle;

    private Integer maxActive;

    private Integer maxWait;

    private Integer timeBetweenEvictionRunsMillis;

    private Integer minEvictableIdleTimeMillis;

    private String validationQuery;

    private Boolean testWhileIdle;

    private Boolean testOnBorrow;

    private Boolean testOnReturn;

    private Boolean poolPreparedStatements;

    private Integer maxPoolPreparedStatementPerConnectionSize;

    private String filters;

    private String connectionProperties;
}
