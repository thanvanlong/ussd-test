package com.example.ussdtest;


import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @PostMapping("/text")
    public String menu(@RequestParam String text){
        System.out.println(text);


        return "What is your choice </br> 1. My phone number";
    }

}
