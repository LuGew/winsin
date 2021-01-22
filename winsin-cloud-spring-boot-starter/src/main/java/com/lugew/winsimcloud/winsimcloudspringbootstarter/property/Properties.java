package com.lugew.winsimcloud.winsimcloudspringbootstarter.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 夏露桂
 * @since 2021/1/21 12:27
 */
@ConfigurationProperties(prefix = "winsim-cloud")
@Getter
@Setter
public class Properties {
    private Boolean enableStandardResponse;
}
