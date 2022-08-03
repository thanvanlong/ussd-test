package com.example.ussdtest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @PostMapping("/text")
    public String menu(){

        System.out.println(text);

        return "CON What is your choice </br> 1. My phone number";
    }

}
