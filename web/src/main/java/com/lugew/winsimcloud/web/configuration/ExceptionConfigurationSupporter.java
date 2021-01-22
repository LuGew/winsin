package com.lugew.winsimcloud.web.configuration;

import com.lugew.winsmcloud.core.exception.Exception;

/**
 * @author 夏露桂
 * @since 2021/1/21 11:06
 */
public interface ExceptionConfigurationSupporter {
    String getMessage(Exception exception);
}
