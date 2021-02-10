package com.yuanwj.batch;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.yuanwj.batch.model.UserEntity;
import com.yuanwj.batch.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserTest extends BaseTest {

    @Autowired
    private UserService userService;

    @DatabaseSetup(value = "/dbUnit/T_USER.xml",type = DatabaseOperation.CLEAN_INSERT)
    @ExpectedDatabase(value = "/dbUnit/T_USER_after.xml",assertionMode = DatabaseAssertionMode.NON_STRICT)
    @DatabaseTearDown(value = "/dbUnit/T_USER_after.xml",type = DatabaseOperation.DELETE_ALL)
    @Test
    public void testUser() {
        List<UserEntity> userEntityList = userService.findAll();
        System.out.println(userEntityList.size());
    }
}
