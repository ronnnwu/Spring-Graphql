package com.data.api.loader;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.data.api.model.Person;
import com.data.api.repository.PersonRepository;

@Component
public class PersonLoader {
	
//	@Autowired
//	private PersonRepository personRepository;
//	
//	@PostConstruct
//	public void loadPerson(){
//		personRepository.save( new Person("1", "Adam", "A", 10));
//	}
	
}
