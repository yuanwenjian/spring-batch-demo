package com.yuanwj.batch.service;

import com.yuanwj.batch.model.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> findAll();

}
