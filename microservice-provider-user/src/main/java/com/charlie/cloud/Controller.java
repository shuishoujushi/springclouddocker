package com.charlie.cloud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * Created by charlie on 26/05/2018.
 */
@RestController
public class Controller {

    @Resource
    UserRepository userRepository;

    @GetMapping(value = "/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        Optional<User> findOne = this.userRepository.findById(id);
        return findOne;
    }
}
