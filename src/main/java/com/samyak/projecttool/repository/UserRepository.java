package com.samyak.projecttool.repository;

import com.samyak.projecttool.entity.User;
import com.samyak.projecttool.entity.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByIdAndStatus(Long id, UserStatus status);
}
