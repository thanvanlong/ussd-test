package com.example.ussdtest;


import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;

import java.util.List;

@RestController
public class Controller {

    @PostMapping("/text")
    public String menu(@RequestParam String text){
        System.out.println(text);
        XmlParser xmlParser = new XmlParser();
        try {
            List<Content> menu  =
                     xmlParser
                             .loadStates(
                                     "src/main/java/com/example/ussdtest/state.xml"
                                     ,"Vietnamese");
            System.out.println("CON " + menu.get(1).toString());
            return "CON " + menu.get(1).toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }

}
