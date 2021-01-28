package com.lugew.winsin.example.service;

import com.lugew.winsin.core.exception.Exception;
import com.lugew.winsin.example.entity.User;
import com.lugew.winsin.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 夏露桂
 * @date 2020/12/31 17:44
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserService extends BasicService<UserRepository, User, Long> {

    public User loadUserByUsername(String username) {
        log.info("username:{}", username);
        User user = getDao().findByName(username)
                .orElseThrow(() -> new Exception("user.not.found"));
        return generateUserDetails(user);
    }

    public User generateUserDetails(User user) {
        return user;
    }

}
