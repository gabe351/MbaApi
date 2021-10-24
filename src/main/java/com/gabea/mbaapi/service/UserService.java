package com.gabea.mbaapi.service;

import com.gabea.mbaapi.model.User;
import com.gabea.mbaapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAllUsers()  {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public Optional<List<User>> findUsers(Boolean isActive) {
        return userRepository.findUsers(isActive);
    }
}
