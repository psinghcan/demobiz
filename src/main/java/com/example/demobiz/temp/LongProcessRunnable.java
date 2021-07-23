package com.example.demobiz.temp;

import com.example.demobiz.model.ProcessEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class LongProcessRunnable implements Runnable{
    BroadcastWebsocketService broadcastWebsocketService;

    public LongProcessRunnable(BroadcastWebsocketService broadcastWebsocketService)
    {
        this.broadcastWebsocketService = broadcastWebsocketService;
        objectMapper = new ObjectMapper();
    }

    public static String WS_ENDPOINT = "/long-process";

    @Override
    public void run(){
        System.out.println("I am being started....");
        for(int i = 0; i <= 5; ++i)
        {
            try
            {
                ProcessEvent processEvent = new ProcessEvent(i);
                Map<String, Object> payload = new HashMap<>();
                payload.put("id", processEvent.getId());
                payload.put("message", processEvent.getMessage());
                payload.put("description", processEvent.getDescription());
                String json = objectMapper.writeValueAsString(payload);
                this.broadcastWebsocketService.broadcastProgressUpdate(WS_ENDPOINT, json);
                System.out.println("sent process-event from the server for " + i);
                if(i >= 5)
                {
                    Thread.currentThread().interrupt();
                    break;
                }
                Thread.sleep(10000);
            }
            catch(Exception exception)
            {
                System.out.println("errors " + exception);
            }
        }
    }
    private ObjectMapper objectMapper;
}
