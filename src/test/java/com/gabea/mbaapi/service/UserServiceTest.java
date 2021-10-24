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
import java.util.Optional;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void findAllUsersSuccessfully() {
        Optional<List<User>> expectedUserList = Optional.of(UserBuilder.buildUserList());
        Mockito.when(userRepository.findUsers(null)).thenReturn(expectedUserList);

        Optional<List<User>> actualUserList = userService.findUsers(null);
        Assertions.assertEquals(expectedUserList, actualUserList);
    }

    @Test
    public void findNoUsers() {
        Optional<List<User>> expectedUserList = Optional.empty();
        Mockito.when(userService.findUsers(null)).thenReturn(expectedUserList);

        Optional<List<User>> actualUserList = userService.findUsers(null);
        Assertions.assertEquals(expectedUserList, actualUserList);
    }

}
