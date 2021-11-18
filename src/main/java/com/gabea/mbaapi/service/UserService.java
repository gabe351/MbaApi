package com.gabea.mbaapi.service;

import com.gabea.mbaapi.model.User;
import com.gabea.mbaapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        Optional<User> originalUserOptional =  userRepository.findById(user.getId());
        if (originalUserOptional.isPresent()) {
            User originalUser = originalUserOptional.get();

            originalUser.setName(user.getName());
            originalUser.setActive(user.isActive());
            originalUser.setAssociated(user.isAssociated());
            originalUser.setUserType(user.getUserType());
            originalUser.setEmail(user.getEmail());
            originalUser.setPassword(user.getPassword());
            originalUser.setCreatedAt(user.getCreatedAt());
            originalUser.setUpdatedAt(user.getUpdatedAt());
            originalUser.setSituation(user.getSituation());

            return userRepository.save(originalUser);
        } else {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Bad request");
        }
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
