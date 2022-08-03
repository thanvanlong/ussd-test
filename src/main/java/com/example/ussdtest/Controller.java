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
             menu = xmlParser.loadStates("https://github.com/thanvanlong/ussd-test/blob/b48ca455c40c5157e5a5cc26194f51e7a67fd037/src/main/java/com/example/ussdtest/state.xml","Vietnamese");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return menu.get(1).toString();
    }

}
