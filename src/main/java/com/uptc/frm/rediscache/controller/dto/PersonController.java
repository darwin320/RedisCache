package com.uptc.frm.rediscache.controller.dto;

import com.uptc.frm.rediscache.jpa.entity.Person;
import com.uptc.frm.rediscache.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{idPerson}")
    public Person getPersonById(@PathVariable int idPerson) {
        return personService.findById(idPerson);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.findAll();
    }

    @PostMapping
    public Person save(@RequestBody Person person) {
        return personService.save(person);
    }

    @DeleteMapping("/{idPerson}")
    public void deleteById(@PathVariable int idPerson) {
        personService.delete(idPerson);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable int id,@RequestBody Person person) {
        return personService.update(id, person);
    }

}