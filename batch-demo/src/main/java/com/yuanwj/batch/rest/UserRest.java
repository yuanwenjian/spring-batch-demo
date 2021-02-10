package com.yuanwj.batch.rest;

import com.yuanwj.batch.model.UserEntity;
import com.yuanwj.batch.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yuanwj
 */
@RestController
@RequestMapping("/user")
public class UserRest {

    private final UserService userService;

    public UserRest(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public List<UserEntity> findAll() {
        return userService.findAll();
    }
}
