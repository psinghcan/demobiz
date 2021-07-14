package com.example.demobiz.controller;

import com.example.demobiz.model.Person;
import com.example.demobiz.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DemoController {

    public DemoController(PersonService personService) {
        this.personService = personService;
    }

    private PersonService personService;

    @RequestMapping("/hello")
    public String sayHello(Model model){
        model.addAttribute("txt", "is this ka kya matlab hai");
        return "helloworld";
    }

    @RequestMapping({"", "/"})
    public String index(Model model){
        return "index";
    }

    @RequestMapping("/persons")
    public String getPersons(Model model){
        List<Person> persons = personService.getPersons();
        model.addAttribute("persons", persons);
        return "persons";
    }
}
