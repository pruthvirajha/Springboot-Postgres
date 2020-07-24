package com.example.postgresdemo.controller;

import com.example.postgresdemo.model.Address;
import com.example.postgresdemo.model.Person;
import com.example.postgresdemo.repository.PersonRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class PersonController {

    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @PostMapping("/massPersonInsert")
    public String massPersonInsert(@RequestParam("count") int count) {
        Person person = null;
        Address address = new Address();
        address.setCity("California");
        address.setHouseNo("121");
        address.setPincodes(Arrays.asList("21212"));
        address.setStreet("UP road");


        for (int i = 0; i < count; i++) {
            int id = (i + 1);
            person = new Person("Name" + id, id, address);
            personRepository.save(person);
        }

        return "inserted all the rows";
    }
}
