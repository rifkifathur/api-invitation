package com.undangan.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.undangan.model.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}
