package com.example.ussdtest;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @PostMapping("/text/{text}")
    public String menu(@PathVariable String text){

        System.out.println(text);

        return "CON What is your choice \n 1. My phone number";
    }

}
