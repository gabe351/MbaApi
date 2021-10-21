package com.gabea.mbaapi.service;

import com.gabea.mbaapi.model.User;
import com.gabea.mbaapi.repository.UserRepository;
import com.gabea.mbaapi.service.UserService;
import com.gabea.mbaapi.utils.UserBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void findAllUsersSuccessfully() {

        List<User> expectedUserList = UserBuilder.buildUserList();
        Mockito.when(userRepository.findAll()).thenReturn(expectedUserList);

        List<User> actualUserList = userService.findAllUsers();
        Assertions.assertEquals(expectedUserList, actualUserList);
    }

    @Test
    public void findNoUsers() {
        List<User> expectedUserList = Collections.emptyList();
        Mockito.when(userRepository.findAll()).thenReturn(expectedUserList);

        List<User> actualUserList = userService.findAllUsers();
        Assertions.assertEquals(expectedUserList, actualUserList);
    }

}
