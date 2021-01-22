package com.lugew.winsimcloud.jpa.service;

import com.lugew.winsmcloud.core.entity.Entity;
import com.lugew.winsmcloud.core.exception.Exception;
import com.lugew.winsmcloud.core.service.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.io.Serializable;
import java.util.List;

/**
 * 抽象CRUD业务逻辑层
 *
 * @author 夏露桂
 * @since 2021/1/14 11:09
 */
@Slf4j
public abstract class AbstractService<T extends Entity<ID>, R extends JpaRepository<T, ID> & QuerydslPredicateExecutor<T>, ID extends Serializable>
        extends com.lugew.winsmcloud.core.service.AbstractService<T, ID>
        implements Service<T, ID> {
    @SuppressWarnings("ALL")
    @Autowired
    protected R repository;

    @Override
    public int count() {
        return (int) getDao().count();
    }

    @Override
    public boolean insert(T entity) {
        preInsert(entity);
        getDao().saveAndFlush(entity);
        return true;
    }

    @Override
    public boolean insert(List<T> entities) {
        preInsert(entities);
        getDao().saveAll(entities);
        return true;
    }


    @Override
    public boolean delete(ID id) {
        T entity = (T) new Object();
        entity.setId(id);
        preDelete(entity);
        return update(entity);
    }

    @Override
    public T get(ID id) {
        return getDao().getOne(id);
    }

    @Override
    public T get(T entity) {
        return getDao().findOne(Example.of(entity)).orElseThrow(() -> new Exception("entity.not.found"));
    }

    @Override
    public boolean exists(ID id) {
        return getDao().existsById(id);
    }

    @Override
    public List<T> getList(T entity) {
        return getDao().findAll(Example.of(entity));
    }

    @Override
    public boolean update(T entity) {
        getDao().saveAndFlush(entity);
        return true;
    }

    @Override
    public Object getPagingList(T entity, int pageIndex, int pageSize) {
        return getDao().findAll(Example.of(entity), PageRequest.of(pageIndex, pageSize));
    }

    @Override
    public R getDao() {
        return repository;
    }


}
