package com.uptc.frm.rediscache.service;

import com.uptc.frm.rediscache.jpa.entity.Person;
import com.uptc.frm.rediscache.jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person findById(int id) {
        Optional<Person> person = personRepository.findById(id);
        return person.orElse(null);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public void delete(int id) {
        personRepository.deleteById(id);
    }

    public Person update(int id, Person person) {
        Person person1 = findById(id);
        if (person1 != null) {
            person1.setName(person.getName());
            person1.setDate(person.getDate());
            person1.setAddress(person.getAddress());
            person1.setPhoneNumber(person.getPhoneNumber());
            return save(person1);
        }
        throw new RuntimeException("Person not found");
    }

}
