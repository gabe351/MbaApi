package com.gabea.mbaapi.controller;

import com.gabea.mbaapi.exceptions.NoUsersFoundException;
import com.gabea.mbaapi.model.User;
import com.gabea.mbaapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(value = "isActive", required = false) Boolean isActive) {
        Optional<List<User>> userList = userService.findUsers(isActive);
        if (userList.isEmpty()) {
            throw new NoUsersFoundException("No Users were found");
        }
        return ResponseEntity.ok(userList.get());

    }
}
