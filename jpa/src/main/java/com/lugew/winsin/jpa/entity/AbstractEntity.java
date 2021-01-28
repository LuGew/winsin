package com.lugew.winsin.jpa.entity;

import com.lugew.winsin.core.entity.Entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;


@MappedSuperclass
public abstract class AbstractEntity<I extends Serializable> implements Entity<I> {
    protected I id;
    protected Long creator;
    protected Long modifier;
    protected LocalDateTime createDateTime;
    protected LocalDateTime modifyDateTime;
    protected Boolean deleted;

    @Override
    @Id
    public I getId() {
        return id;
    }

    @Override
    public void setId(I id) {
        this.id = id;
    }

    @Override
    public Long getCreator() {
        return creator;
    }

    @Override
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    @Override
    public Long getModifier() {
        return modifier;
    }

    @Override
    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    @Override
    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    @Override
    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    @Override
    public LocalDateTime getModifyDateTime() {
        return modifyDateTime;
    }

    @Override
    public void setModifyDateTime(LocalDateTime modifyDateTime) {
        this.modifyDateTime = modifyDateTime;
    }

    @Override
    public Boolean getDeleted() {
        return deleted;
    }

    @Override
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
