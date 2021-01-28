package com.lugew.winsin.web.response;


import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @param <DATA> 数据泛型
 * @author 夏露桂
 * @since 2021/1/16 16:40
 */
@SuperBuilder
@AllArgsConstructor
public class R<DATA> extends StringCodeResult<DATA> {
}
