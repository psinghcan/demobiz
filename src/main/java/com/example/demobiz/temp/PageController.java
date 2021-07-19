package com.example.demobiz.temp;

import com.example.demobiz.model.SampleViewModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    public PageController(BroadcastWebsocketService broadcastWebsocketService){
        this.broadcastWebsocketService = broadcastWebsocketService;
        objectMapper = new ObjectMapper();
    }

    @MessageMapping("/test")
    @SendTo("/ws-broadcast/update-progress")
    public String updateProgress() throws Exception
    {
        return "";
    }

    @RequestMapping(value = "/temp")
    public String index()
    {
        return "temp";
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String upload(@RequestBody SampleViewModel sampleViewModel)
    {
        new SendProgressRunnable(broadcastWebsocketService).run();
        return "";
    }

    @RequestMapping(value = "process-dictionary", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String processDictionary(@RequestBody SampleViewModel sampleViewModel)
    {
        new ProcessDictionaryRunnable(broadcastWebsocketService, objectMapper).run();
        return "";
    }

    private BroadcastWebsocketService broadcastWebsocketService;
    private ObjectMapper objectMapper;
}
