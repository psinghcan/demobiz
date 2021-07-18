package com.example.demobiz.controller;

import com.example.demobiz.model.Model1;
import com.example.demobiz.model.ProcessEvent;
import com.example.demobiz.service.ProcessService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class Process1Controller {

    public Process1Controller(ProcessService processService){
        this.processService = processService;
    }


    @GetMapping("/process1")
    public String step1(Model model){
        Model1 model1 = new Model1();
        model1.setName("bablee singh");
        model.addAttribute("model1", model1);
        return "process1";
    }

    @PostMapping("/process1")
    public String step2(@ModelAttribute Model1 model1, Model model){
        List<ProcessEvent> events = processService.longProcess();
        String result = "nice work done: " + model1.getName();
        model.addAttribute("result", result);
        model.addAttribute("events", events);
        return "process1result";
    }

    private ProcessService processService;

}
