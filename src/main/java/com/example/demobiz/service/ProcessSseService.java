package com.example.demobiz.service;

import com.example.demobiz.model.ProcessEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProcessSseService {
    public void longProcess(SseEmitter sseEmitter){
        try{
            List<ProcessEvent> list = new ArrayList<>();
            for (int i=0; i < 10; i++){
                Random random = new Random();
                BigInteger b = new BigInteger(2000, random);
                BigInteger o = b.nextProbablePrime();
                sseEmitter.send("is this ka kya matlab hai " + i);
            }
        } catch (Exception e){
            System.out.println("errors " + e);
        }
//        sseEmitter.complete();
    }







}
