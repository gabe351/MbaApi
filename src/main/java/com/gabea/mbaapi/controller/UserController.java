package com.gabea.mbaapi.controller;

import com.gabea.mbaapi.exceptions.NoUsersFoundException;
import com.gabea.mbaapi.model.User;
import com.gabea.mbaapi.model.response.UserResponse;
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
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<UserResponse> getAllUsers(@RequestParam(value = "isActive", required = false) Boolean isActive) {
        Optional<List<User>> userList = userService.findUsers(isActive);
        if (userList.isEmpty()) {
            return new ResponseEntity<UserResponse>(UserResponse.personalizedResponse(null, 204, "No users were found"), HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(UserResponse.success(userList.get()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Integer id) {
        Optional<User> userOptional = userService.findById(id);

        return userOptional.map(user -> ResponseEntity.ok(UserResponse.successResponseForSingleUser(user))).orElseGet(() -> ResponseEntity.badRequest().body(UserResponse.personalizedResponse(null, 400, "No Users were found")));
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid User user) {
        if (user != null) {
            userService.createUser(user);
        } else {
           return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponse.personalizedResponseForSingleUser(user, 201, "Created"));
    }

    @PutMapping
    public ResponseEntity<UserResponse> updateUser(@RequestBody User user, @PathVariable Integer id) {
        user.setId(id);
        if (userService.updateUser(user).isPresent()) {
            return ResponseEntity.ok(UserResponse.successResponseForSingleUser(user));
        } else {
            return ResponseEntity.badRequest().body(UserResponse.personalizedResponse(null, 400, "No users were found"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteUserById(@PathVariable Integer id) {
        Optional<User> userOptional = userService.findById(id);

        if (userOptional.isPresent()) {
            userService.deleteUser(userOptional.get());
            return ResponseEntity.ok(UserResponse.success(null));
        } else {
            return ResponseEntity.badRequest().body(UserResponse.personalizedResponse(null, 400, "No Users were found with this id"));
        }
    }

}
