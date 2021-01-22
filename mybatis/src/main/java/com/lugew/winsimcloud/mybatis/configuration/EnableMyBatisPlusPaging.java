package com.lugew.winsimcloud.mybatis.configuration;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author 夏露桂
 * @since 2021/1/20 18:20
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MybatisPlusConfiguration.class)
public @interface EnableMyBatisPlusPaging {
}
