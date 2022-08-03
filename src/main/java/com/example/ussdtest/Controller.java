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
        List<Content> menu = null;
        try {
             menu = xmlParser.loadStates("E:\\TinaSoft\\ishare-viettel\\ussdapp_source\\etc\\states.xml","Vietnamese");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return menu.get(1).toString();
    }

}
