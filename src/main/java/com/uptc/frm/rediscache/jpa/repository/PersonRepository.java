package com.uptc.frm.rediscache.jpa.repository;

import com.uptc.frm.rediscache.jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Integer> {

}
