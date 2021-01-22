package com.lugew.winsimcloud.web;

import java.lang.annotation.*;

/**
 * 标准响应注解，
 * 可以添加在{@link org.springframework.web.bind.annotation.RestController}注解标注的类上，开启标准响应
 * 也可以直接继承{@link AbstractController}
 * 要使该注解生效，应用需使用{@link com.lugew.winsimcloud.web.configuration.EnableStandardResponse}
 *
 * @author 夏露桂
 * @since 2021/1/19 10:52
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface Standard {
}
