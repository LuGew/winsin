package com.lugew.winsimcloud.web.configuration;

import com.lugew.winsimcloud.web.advice.GlobalResponseBodyAdvice;
import org.springframework.context.annotation.Bean;

/**
 * 标准响应配置
 *
 * @author 夏露桂
 * @since 2021/1/19 19:11
 */
public class RConfiguration {
    @Bean
    public GlobalResponseBodyAdvice globalResponseBodyAdvice(
            @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
                    ExceptionConfigurationSupporter exceptionConfigurationSupporter) {
        return new GlobalResponseBodyAdvice(exceptionConfigurationSupporter);
    }
}
