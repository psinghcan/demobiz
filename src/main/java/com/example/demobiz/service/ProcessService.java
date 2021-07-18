package com.example.demobiz.service;

import com.example.demobiz.model.ProcessEvent;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProcessService {

    public List<ProcessEvent> longProcess(){
        List<ProcessEvent> list = new ArrayList<>();
        for (int i=0; i < 10; i++){
            Random random = new Random();
            BigInteger b = new BigInteger(500, random);
            BigInteger o = b.nextProbablePrime();
            list.add(ProcessEvent.builder()
                            .id(i)
                            .message("this is being worked on")
                    .build());
        }
        return list;
    }

}
