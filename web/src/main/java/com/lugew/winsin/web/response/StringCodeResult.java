package com.lugew.winsin.web.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * 业务代码为String类型
 *
 * @author 夏露桂
 * @since 2021/1/16 16:37
 */
@SuperBuilder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class StringCodeResult<DATA> extends AbstractResult<String, DATA> {
    @Builder.Default
    private String code = "ok";
}
