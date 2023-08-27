package com.picpaysimplificado.picpaysimplificado.Repostory;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepostory extends JpaRepository<User , Long> {
    Optional<User> findByDocument(String Document);

    Optional<User> findUserById(Long id);

}
