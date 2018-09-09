package com.charlie.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Optional;

/**
 * Author: Charie
 * 09/09/2018 12:01
 **/
@RestController
public class SecurityController {
    private static final Logger logger = LoggerFactory.getLogger(SecurityController.class);

    @Resource
    private UserRepository userRepository;

    @GetMapping("/security/{id}")
    public Optional findById(@PathVariable("id") Long id) {
        Object pricipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (pricipal instanceof UserDetails) {
            UserDetails user = (UserDetails) pricipal;
            Collection<? extends GrantedAuthority> collection = user.getAuthorities();
            for (GrantedAuthority authority : collection) {
                // 打印当前用户信息
                logger.info("当前用户是{}，角色是{}", user.getUsername(), authority.getAuthority());
            }
        } else {
            //
            logger.info("非正常用户");
        }
        Optional findOne = this.userRepository.findById(id);
        return findOne;
    }

}
