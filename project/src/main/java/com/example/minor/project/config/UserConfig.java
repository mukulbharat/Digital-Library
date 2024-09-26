package com.example.minor.project.config;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@ToString
@Slf4j
public class UserConfig implements InitializingBean {
    /*
    * specify here
    * */

    @Value("${student.book.quota}")
    Integer studentQuota;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("values {}", this);
    }
}
