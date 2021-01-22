package com.lugew.winsmcloud.core.service;

import com.lugew.winsmcloud.core.entity.Entity;
import com.lugew.winsmcloud.core.exception.Exception;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * 抽象CRUD业务逻辑层
 *
 * @author 夏露桂
 * @since 2021/1/14 11:09
 */
public abstract class AbstractService<T extends Entity<ID>, ID extends Serializable>
        implements Service<T, ID> {

    protected <S extends T> void preInsert(List<S> entities) {
        Optional.ofNullable(entities).ifPresentOrElse(elements -> {
            for (S element : elements) {
                preInsert(element);
            }
        }, () -> {
            throw new Exception("entities.cant.be.null");
        });
    }

    protected void preInsert(T entity) {
        entity.setCreator(getUserId());
        entity.setCreateDateTime(LocalDateTime.now());
        entity.setDeleted(false);
    }

    protected void preUpdate(T entity) {
        entity.setModifier(getUserId());
        entity.setModifyDateTime(LocalDateTime.now());
    }

    protected void preDelete(T entity) {
        preUpdate(entity);
        entity.setDeleted(true);
    }

    public abstract Long getUserId();

}
