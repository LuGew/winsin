package com.lugew.winsimcloud.winsimcloudspringbootstarter.configuration;

import com.lugew.winsimcloud.winsimcloudspringbootstarter.property.Properties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author 夏露桂
 * @since 2021/1/21 12:30
 */
@Configuration
@EnableConfigurationProperties(Properties.class)
@RequiredArgsConstructor
public class AutoConfiguration {
    private final Properties properties;

}
