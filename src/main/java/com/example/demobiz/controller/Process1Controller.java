package com.example.demobiz.controller;

import com.example.demobiz.model.Model1;
import com.example.demobiz.model.ProcessEvent;
import com.example.demobiz.service.ProcessSseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class Process1Controller {

    public Process1Controller(ProcessSseService processSseService){
        this.processSseService = processSseService;
    }


    @GetMapping("/process1")
    public String step1(Model model){
        Model1 model1 = new Model1();
        model1.setName("bablee singh");
        model.addAttribute("model1", model1);
        return "process1";
    }

    @GetMapping("/events")
    public SseEmitter handle(){
        SseEmitter sseEmitter = new SseEmitter();
        threadPool.execute(() -> processSseService.longProcess(sseEmitter));
        return sseEmitter;
    }

    @GetMapping("/progressBar")
    public String progressBar(){
        return "progressBar";
    }

    @GetMapping("/dictionaryWords")
    public String longProcess(){
        return "dictionaryWords";
    }


    @PostMapping("/process1")
    public String step2(@ModelAttribute Model1 model1, Model model){
        List<ProcessEvent> events = new ArrayList<>();
        processSseService.longProcess(null);
        String result = "nice work done: " + model1.getName();
        model.addAttribute("result", result);
        model.addAttribute("events", events);
        return "process1result";
    }

    private ProcessSseService processSseService;
    private final ExecutorService threadPool = Executors.newCachedThreadPool();

}
