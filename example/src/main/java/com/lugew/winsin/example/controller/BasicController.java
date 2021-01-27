package com.lugew.winsin.example.controller;


import com.lugew.winsin.core.entity.Entity;
import com.lugew.winsin.core.service.Service;
import com.lugew.winsin.web.AbstractController;

import java.io.Serializable;

/**
 * @author 夏露桂
 * @since 2021/1/20 16:36
 */
public class BasicController<T extends Entity<ID>, S extends Service<T, ID>, ID extends Serializable>
        extends AbstractController<T, S, ID> {
}
