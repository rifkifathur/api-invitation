package com.undangan.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.undangan.model.entities.Theme;
import com.undangan.repositories.ThemeRepository;
import com.undangan.services.ThemeService;

@Service
public class ThemeServiceImpl implements ThemeService{
    
    @Autowired
    ThemeRepository themeRepository;

    @Override
    public Theme create(Theme theme){
        return themeRepository.save(theme);
    }

    @Override
    public Theme update(Long id, Theme theme){
        // Theme.getId();
        
        return themeRepository.save(theme);
        // return Theme;
    }

    @Override
    public void delete(Long id){
        themeRepository.deleteById(id);
    }

    @Override
    public Theme findById(Long id){
        return themeRepository.findById(id).get();
    }

    @Override
    public List<Theme> findAll() {
        return themeRepository.findAll();
    }
}
