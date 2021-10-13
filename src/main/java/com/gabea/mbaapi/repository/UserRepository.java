package com.gabea.mbaapi.repository;

import com.gabea.mbaapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
