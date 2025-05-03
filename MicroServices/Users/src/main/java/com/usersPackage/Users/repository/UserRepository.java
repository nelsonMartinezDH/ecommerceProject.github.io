package com.usersPackage.Users.repository;

import com.usersPackage.Users.entity.Role;
import com.usersPackage.Users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    //Query Methods

    //Simples
    Optional<User> findByusername(String username);
    List<User> findByEmail(String email);

    //Compuestos
    List<User> findByusernameAndRole(String username, Role role);
}
