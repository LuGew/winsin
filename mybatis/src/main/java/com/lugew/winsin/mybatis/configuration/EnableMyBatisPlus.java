package com.lugew.winsin.mybatis.configuration;


import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusLanguageDriverAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author 夏露桂
 * @since 2021/1/20 18:20
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({MybatisPlusLanguageDriverAutoConfiguration.class, MybatisPlusAutoConfiguration.class})
public @interface EnableMyBatisPlus {
}
