package com.example.demobiz.service;

import com.example.demobiz.model.Person;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class PersonService {
    private List<Person> persons = new ArrayList<>();

    @PostConstruct
    private void init(){
        for (int i= 0; i< 10; i++){
            persons.add(makePerson(i));
        }
    }

    private Person makePerson(int i){
        Person person = new Person();
        person.setFirstName("lovely firstname " + i);
        person.setLastName("lovely lastname " + i);
        person.setEmail("lovely" + i + "@lovely.com");
        person.setPhone("444-333-33" + i);
        person.setAge(20 + i);
        person.setMale((i|2) == 0);
        return person;
    }

}
