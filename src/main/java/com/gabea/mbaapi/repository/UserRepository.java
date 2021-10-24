package com.gabea.mbaapi.repository;

import com.gabea.mbaapi.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u from User u WHERE (:status is null or u.isActive = :status) ORDER BY u.name ASC ")
    Optional<List<User>> findUsers(@Param("status") Boolean isActive);
}
