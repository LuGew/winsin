package com.lugew.winsmcloud.core.service;

import com.lugew.winsmcloud.core.entity.Entity;

import java.util.List;


/**
 * 业务逻辑层接口
 * 删除皆时逻辑删除
 *
 * @author LuGew g
 */
public interface Service<T extends Entity<ID>, ID> {

    boolean insert(T entity);

    boolean insert(List<T> entities);

    boolean update(T entity);

    boolean delete(ID key);

    int count();

    T get(ID key);

    T get(T entity);

    boolean exists(ID key);

    List<T> getList(T entity);

    Object getPagingList(T entity, int pageIndex, int pageSize);

    Object getDao();

}
