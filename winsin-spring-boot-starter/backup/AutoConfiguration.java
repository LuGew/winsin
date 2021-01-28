package com.lugew.winsin.winsinspringbootstarter.configuration;

import com.lugew.winsin.winsinspringbootstarter.property.Properties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author 夏露桂
 * @since 2021/1/21 12:30
 */
@Configuration
@EnableConfigurationProperties(Properties.class)
@RequiredArgsConstructor
@Slf4j
public class AutoConfiguration {
    private final Properties properties;
}
