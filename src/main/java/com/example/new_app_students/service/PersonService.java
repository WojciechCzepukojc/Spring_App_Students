package com.example.new_app_students.service;

import com.example.new_app_students.model.Person;
import com.example.new_app_students.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void addPerson(Person person){
        personRepository.save(person);
        System.out.println("added new person: " + person.getId());
    }

    public List<Person> getPersons(){
        return personRepository.findAll();
    }

    public Person getPersonById(Long id){
        return personRepository.findById(id).orElse(null);
    }

    public void editPerson(Person person){
        personRepository.save(person);
    }

    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }
}
