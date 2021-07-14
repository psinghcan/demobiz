package com.example.demobiz.controller;

import com.example.demobiz.model.Model1;
import com.example.demobiz.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Process1Controller {

    @GetMapping("/ebiz/process1")
    public String step1(Model model){
        Model1 model1 = new Model1();
        model1.setName("bablee singh");
        model.addAttribute("model1", model1);
        return "ebiz/process1";
    }

    @PostMapping("/ebiz/process1")
    public String step2(@ModelAttribute Model1 model1, Model model){
        System.out.println("i am inside step2: model1 recieved is " + model1);

        String result = "nice work done: " + model1.getName();
        model.addAttribute("result", result);
        return "ebiz/process1result";
    }

}
