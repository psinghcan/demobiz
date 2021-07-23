package com.example.demobiz.controller;

import com.example.demobiz.model.SampleViewModel;
import com.example.demobiz.service.ProcessService;
import com.example.demobiz.temp.BroadcastWebsocketService;
import com.example.demobiz.temp.LongProcessRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class ProcessController {
//    public ProcessController(ProcessService processService){
//        this.processService = processService;
//    }

    @RequestMapping(value = "longProcess", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String longProcess(@RequestBody SampleViewModel sampleViewModel)
    {
//        executorService.submit(()-> processService.startLongProcess());
//        new Thread(processService).start();
        new LongProcessRunnable(broadcastWebsocketService).run();
        return "";
    }

    @GetMapping("/longProcess")
    public String longProcessPage(){
        return "longProcess";
    }

//    private ProcessService processService;
//    private ExecutorService executorService = Executors.newCachedThreadPool();

    @Autowired
    BroadcastWebsocketService broadcastWebsocketService;


}
