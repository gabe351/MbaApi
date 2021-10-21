package com.gabea.mbaapi.service;

import com.gabea.mbaapi.model.User;
import com.gabea.mbaapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAllUsers()  {
        return userRepository.findAll();
    }
}
