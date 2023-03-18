package com.djoumatch.test.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.number = :number")
    Optional<User> getUserByContact(@Param("number") String number);

    Optional<User> findByNumber(String number);
}
