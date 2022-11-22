package com.undangan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.undangan.model.ResponseData;
import com.undangan.model.entities.Theme;
import com.undangan.services.ThemeService;

@RestController
public class ThemeController {
    
    @Autowired
    private ThemeService themeService;

    @GetMapping("/api/theme")
    public List<Theme> findAll(){
    
        ResponseData<List<Theme>> responseTheme = new ResponseData<>();
        responseTheme.setCode(200);
        responseTheme.setStatus("OK");
        responseTheme.setData(themeService.findAll());

        // return ResponseEntity
        //         .status(HttpStatus.OK)
        //         .contentType(MediaType.APPLICATION_JSON)
        //         .body(responseTheme);
        return themeService.findAll();
    }

    @PostMapping("/api/theme")
    public ResponseEntity<ResponseData<Theme>> create (@RequestBody @Validated Theme theme){

        ResponseData<Theme> responseTheme = new ResponseData<>();
        responseTheme.setCode(200);
        responseTheme.setStatus("OK");
        responseTheme.setData(themeService.create(theme));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseTheme);
    }
}
