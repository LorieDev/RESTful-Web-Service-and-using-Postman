package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetPages {

    @GetMapping("/")
    public String welcome() {
        return "Welcome";
    }
}