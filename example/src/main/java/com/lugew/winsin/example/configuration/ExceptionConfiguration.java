package com.lugew.winsin.example.configuration;

import com.lugew.winsin.core.exception.Exception;
import com.lugew.winsin.web.configuration.ExceptionConfigurationSupporter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * @author 夏露桂
 * @since 2021/1/21 11:22
 */
@Configuration
@RequiredArgsConstructor
public class ExceptionConfiguration implements ExceptionConfigurationSupporter {
    private final MessageSource messageSource;

    @Override
    public String getMessage(Exception exception) {
        return messageSource.getMessage(exception.getKey(), exception.getValue(), LocaleContextHolder.getLocale());
    }
}
