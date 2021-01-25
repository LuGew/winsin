package com.lugew.winsin.mybatis.entity;

import com.lugew.winsin.core.entity.Entity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 夏露桂
 * @since 2021/1/20 15:19
 */
@Getter
@Setter
public abstract class AbstractEntity<ID extends Serializable> implements Entity<ID> {
    protected ID id;
    protected Long creator;
    protected Long modifier;
    protected LocalDateTime createDateTime;
    protected LocalDateTime modifyDateTime;
    protected Boolean deleted;
}
