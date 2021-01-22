package com.lugew.winsmcloud.core.exception;

/**
 * 含有键
 *
 * @author 夏露桂
 * @since 2021/1/11 18:08
 */
public interface Key<T> {
    T getKey();

    void setKey(T key);
}
