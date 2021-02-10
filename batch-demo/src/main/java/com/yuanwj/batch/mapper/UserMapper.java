package com.yuanwj.batch.mapper;

import com.yuanwj.batch.model.UserEntity;

import java.util.List;

/**
 *
 * @description:
 * @author: yuanwj
 * @date: 2020/09/30 11:48
 **/
public interface UserMapper {

    List<UserEntity> findAll();
}
