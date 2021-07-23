package com.example.demobiz.service;

import com.example.demobiz.model.ProcessEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProcessService {
    public ProcessService(SimpMessagingTemplate simpMessagingTemplate){
        messagingTemplate = simpMessagingTemplate;
        objectMapper = new ObjectMapper();
    }
    private boolean beingProcessed = false;
    private int total = 100;
    private List<ProcessEvent> processEvents = new ArrayList<>();

    private SimpMessagingTemplate messagingTemplate;
    private ObjectMapper objectMapper;

    public static String WS_ENDPOINT = "/ws-broadcast/long-progress";
}
