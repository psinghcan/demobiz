package com.example.demobiz.model;

import lombok.Builder;
import lombok.Data;

import java.nio.charset.Charset;
import java.util.Random;

@Data
public class ProcessEvent {
    public ProcessEvent(int i ){
        id = i;
        description = makeDescription();
        message = "good " + i + " message";

    }

    private long id;
    private String message;
    private String description;

    private String makeDescription(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

}
