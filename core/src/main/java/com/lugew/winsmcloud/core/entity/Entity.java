package com.lugew.winsmcloud.core.entity;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 实体接口
 *
 * @param <ID> 主键泛型
 */
public interface Entity<ID> extends Serializable {
    /**
     * 获取主键
     *
     * @return T 泛型id
     */
    ID getId();

    /**
     * 设置主键
     *
     * @param id 泛型主键
     */
    void setId(ID id);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);

    Long getCreator();

    void setCreator(Long creator);

    LocalDateTime getCreateDateTime();

    void setCreateDateTime(LocalDateTime createDateTime);

    Long getModifier();

    void setModifier(Long modifier);

    LocalDateTime getModifyDateTime();

    void setModifyDateTime(LocalDateTime modifyDateTime);
}
