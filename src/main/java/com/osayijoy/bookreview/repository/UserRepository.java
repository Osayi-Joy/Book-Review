package com.osayijoy.bookreview.repository;

import com.osayijoy.bookreview.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
  Optional<User> findByUsername(String username);
  User findByEmail(String email);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
  

  
}
