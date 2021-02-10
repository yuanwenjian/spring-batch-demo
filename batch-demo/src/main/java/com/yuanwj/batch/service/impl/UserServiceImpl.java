package com.yuanwj.batch.service.impl;

import com.yuanwj.batch.mapper.UserMapper;
import com.yuanwj.batch.model.UserEntity;
import com.yuanwj.batch.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<UserEntity> findAll() {
        return userMapper.findAll();
    }
}
