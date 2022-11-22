package com.undangan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.undangan.model.entities.Theme;

public interface ThemeRepository extends JpaRepository<Theme, Long> {
    
}
