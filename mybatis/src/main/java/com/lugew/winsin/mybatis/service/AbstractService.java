package com.lugew.winsin.mybatis.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lugew.winsin.core.entity.Entity;
import com.lugew.winsin.core.exception.Exception;
import com.lugew.winsin.core.service.Service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author 夏露桂
 * @since 2021/1/20 14:29
 */
public abstract class AbstractService<M extends BaseMapper<T>, T extends Entity<ID>, ID extends Serializable> extends ServiceImpl<M, T> implements Service<T, ID> {
    @Override
    public boolean insert(T entity) {
        preInsert(entity);
        return save(entity);
    }

    @Override
    public boolean insert(List<T> entities) {
        preInsert(entities);
        return saveBatch(entities);
    }

    @Override
    public boolean update(T entity) {
        preUpdate(entity);
        return super.updateById(entity);
    }

    @Override
    public boolean delete(ID key) {
        return super.removeById(key);
    }

    @Override
    public T get(ID key) {
        return super.getById(key);
    }

    @Override
    public T get(T entity) {
        return super.getOne(new QueryWrapper<>(entity));
    }

    @Override
    public boolean exists(ID key) {
        return super.getById(key) != null;
    }

    @Override
    public List<T> getList(T entity) {
        return super.list(new QueryWrapper<>(entity));
    }

    @Override
    public Object getPagingList(T entity, int pageIndex, int pageSize) {
        return getDao().selectPage(new Page<>(pageIndex, pageSize), new QueryWrapper<>(entity));
    }

    @Override
    public int count() {
        return super.count();
    }

    @Override
    public int count(Wrapper<T> queryWrapper) {
        return super.count(queryWrapper);
    }

    @Override
    public M getDao() {
        return getBaseMapper();
    }


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
