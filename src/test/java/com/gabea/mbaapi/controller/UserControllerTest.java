package com.gabea.mbaapi.controller;

import com.gabea.mbaapi.model.User;
import com.gabea.mbaapi.service.UserService;
import com.gabea.mbaapi.utils.UserBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void getAllUsersSuccessfully() throws Exception {
        Optional<List<User>> userList = Optional.of(UserBuilder.buildUserList());

        Mockito.when(userService.findUsers(null)).thenReturn(userList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getNoUsers() throws Exception {
        Optional<List<User>> userList = Optional.empty();
        Mockito.when(userService.findUsers(null)).thenReturn(userList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
