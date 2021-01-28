package com.lugew.winsin.core.exception;

/**
 * @author 夏露桂
 * @since 2021/1/11 18:13
 */
public interface KeyValue<T> extends Key<T>, Value {
    String getKeyValue();
}
