package com.example.new_app_students.controller;

import com.example.new_app_students.model.Person;
import com.example.new_app_students.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public String getPersons(Model model){
        List<Person> personList = personService.getPersons();
        model.addAttribute("person", personList);
        return "persons/personList";
    }

    @GetMapping("/addPerson")
    public String getAddPerson(){
        return "persons/addNewPerson";
    }

    @PostMapping ("/addPerson")
    public RedirectView postAddPerson(Person person) {
        personService.addPerson(person);
        return new RedirectView("/persons");
    }

    @GetMapping("/editPerson/{id}")
    public String getEditPerson(@PathVariable("id") Long id, Model model){
        Person person = personService.getPersonById(id);
        model.addAttribute("person", person);
        return "persons/editPerson";
    }

    @PostMapping("/addPerson/{id}")
    public RedirectView postEditPerson(@PathVariable("id") Long id, Person nePerson){
        personService.editPerson(nePerson);
        return new RedirectView("/persons");

    }

    @PostMapping("/editPerson/{id}")
    public RedirectView deletePerson(@PathVariable("id") Long id) {
        personService.deletePerson(id);
        return new RedirectView("/persons");
    }



}
