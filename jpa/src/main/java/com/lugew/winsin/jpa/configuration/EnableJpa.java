package com.lugew.winsin.jpa.configuration;

/**
 * @author 夏露桂
 * @since 2021/1/25 18:43
 */

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author 夏露桂
 * @since 2021/1/20 18:20
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({HibernateJpaAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class})
public @interface EnableJpa {
}
