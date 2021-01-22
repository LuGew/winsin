package com.lugew.winsimcloud.web.response;

/**
 * 响应接口
 *
 * @author 夏露桂
 * @since 2021/1/16 16:27
 */
public interface Result<CODE, DATA> {

    void setData(DATA data);

    DATA getData();

    /**
     * 设置业务代码
     *
     * @param code 业务代码类型，建议使用String类型而不是Integer
     */
    void setCode(CODE code);

    CODE getCode();

    void setMessage(String message);

    String getMessage();

}
