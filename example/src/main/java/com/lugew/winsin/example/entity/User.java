package com.lugew.winsin.example.entity;

import com.lugew.winsin.mybatis.entity.BasicEntity;
import lombok.Getter;
import lombok.Setter;


/**
 * 用户
 *
 * @author 夏露桂
 * @since 2021/1/11 16:53
 */
@Getter
@Setter
public class User extends BasicEntity {

    private String name;

    private String password;

    private String nickname;

}
