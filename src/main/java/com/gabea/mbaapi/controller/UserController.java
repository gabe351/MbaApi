package com.gabea.mbaapi.controller;

import com.gabea.mbaapi.exceptions.NoUsersFoundException;
import com.gabea.mbaapi.model.User;
import com.gabea.mbaapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userService.findAllUsers();
        if (userList.isEmpty()) {
            throw new NoUsersFoundException("No Users were found");
        }
        return ResponseEntity.ok(userList);
    }
}
