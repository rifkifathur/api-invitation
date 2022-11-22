package com.undangan.services;

import java.util.List;

import com.undangan.model.entities.Theme;

public interface ThemeService {
    
    Theme create(Theme theme);

    Theme update(Long id, Theme theme);

    void delete(Long id);

    Theme findById(Long id);

    List<Theme> findAll();
}
