package com.gabea.mbaapi.controller;

import com.gabea.mbaapi.exceptions.NoUsersFoundException;
import com.gabea.mbaapi.model.User;
import com.gabea.mbaapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(value = "isActive", required = false) Boolean isActive) {
        Optional<List<User>> userList = userService.findUsers(isActive);
        if (userList.isEmpty()) {
            throw new NoUsersFoundException("No Users were found");
        }
        return ResponseEntity.ok(userList.get());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        Optional<User> userOptional = userService.findById(id);

        if (userOptional.isPresent()) {
           return ResponseEntity.ok(userOptional.get());
        } else {
           throw new NoUsersFoundException("No users with this id were found");
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        if (user != null) {
            userService.createUser(user);
        } else {
           return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Integer id) {
        user.setId(id);

        userService.updateUser(user);
        return  ResponseEntity.ok(user);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable Integer id) {
        Optional<User> userOptional = userService.findById(id);

        if (userOptional.isPresent()) {
            userService.deleteUser(userOptional.get());
            return ResponseEntity.ok(null);
        } else {
            throw new NoUsersFoundException("No users with this id were found");
        }
    }

}
