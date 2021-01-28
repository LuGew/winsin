package com.lugew.winsin.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lugew.winsin.core.entity.Entity;
import com.lugew.winsin.core.repository.Repository;

/**
 * @author 夏露桂
 * @since 2021/1/20 14:52
 */
public interface BasicMapper<T extends Entity<?>> extends BaseMapper<T>, Repository<T> {
}
