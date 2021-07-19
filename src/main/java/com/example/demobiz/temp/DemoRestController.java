package com.example.demobiz.temp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
    @GetMapping("/dummy")
    public String dummy(){
        return "is this ka kya matlab hai";
    }
}
