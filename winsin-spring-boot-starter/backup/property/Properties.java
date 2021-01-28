package com.lugew.winsin.winsinspringbootstarter.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 夏露桂
 * @since 2021/1/21 12:27
 */
@ConfigurationProperties(prefix = "winsin")
@Getter
@Setter
public class Properties {
    private Boolean enableStandardResponse;
    private Boolean enableMybatis;
}
