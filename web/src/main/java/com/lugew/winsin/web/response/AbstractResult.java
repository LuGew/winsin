package com.lugew.winsin.web.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @author 夏露桂
 * @since 2021/1/16 16:35
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractResult<CODE, DATA> implements Result<CODE, DATA> {
    private CODE code;
    private DATA data;
    @Builder.Default
    private String message = "success";

}
