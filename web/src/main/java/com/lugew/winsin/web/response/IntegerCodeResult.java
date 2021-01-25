package com.lugew.winsin.web.response;

import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 业务代码为数字类型
 *
 * @author 夏露桂
 * @since 2021/1/16 16:37
 */
@SuperBuilder
@AllArgsConstructor
public class IntegerCodeResult<DATA> extends AbstractResult<Integer, DATA> {

}
