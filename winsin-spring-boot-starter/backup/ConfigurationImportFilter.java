package com.lugew.winsin.winsinspringbootstarter.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigurationImportFilter;
import org.springframework.boot.autoconfigure.AutoConfigurationMetadata;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 过滤配置
 *
 * @author 夏露桂
 * @since 2021/1/25 17:32
 */
@Slf4j
public class ConfigurationImportFilter implements AutoConfigurationImportFilter {

    private static final Set<String> SHOULD_SKIP = new HashSet<>(
            Arrays.asList(
                    //jpa
                    "org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration",
                    "org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration",
                    //mybatis plus
                    "com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration",
                    "com.baomidou.mybatisplus.autoconfigure.MybatisPlusLanguageDriverAutoConfiguration"
            ));

    @Override
    public boolean[] match(String[] autoConfigurationClasses, AutoConfigurationMetadata autoConfigurationMetadata) {
        boolean[] matches = new boolean[autoConfigurationClasses.length];
        for (int i = 0; i < autoConfigurationClasses.length; i++) {
//            log.error("class name:{}", autoConfigurationClasses[i]);
//            log.error("configuration metadata:{}", autoConfigurationMetadata.);
            matches[i] = !SHOULD_SKIP.contains(autoConfigurationClasses[i]);
        }
        return matches;
    }
}

