package com.data.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.data.api.model.Person;

@Component
public interface PersonRepository extends JpaRepository<Person, String>{

}
