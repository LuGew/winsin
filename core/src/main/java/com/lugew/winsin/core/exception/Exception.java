package com.lugew.winsin.core.exception;

/**
 * 运行时异常基类
 *
 * @author 夏露桂
 * @since 2021/1/11 17:44
 */
public class Exception extends RuntimeException implements KeyValue<String> {
    private String key;
    private Object[] arguments;

    public Exception() {
    }

    public Exception(String key, Object... arguments) {
        super(key);
        setKey(key);
        setValue(arguments);
    }

    public Exception(Object... arguments) {
        setValue(arguments);
    }

    public Exception(String message) {
        super(message);
        key = message;
    }

    public Exception(String message, Throwable cause) {
        super(message, cause);
        key = message;
    }

    public Exception(Throwable cause) {
        super(cause);
    }

    public Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        key = message;
    }

    @Override
    public Object[] getValue() {
        return this.arguments;
    }

    @Override
    public void setValue(Object... value) {
        this.arguments = value;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }


    @Override
    public String getKeyValue() {
        return key;
    }
}
