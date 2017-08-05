package com.data.api.datafetcher;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.data.api.model.Person;
import com.data.api.repository.PersonRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class PersonDataFetcher implements DataFetcher<Person>{

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public Person get(DataFetchingEnvironment env) { 
		Map argument = env.getArguments();  
//		System.out.println(personRepository.getOne((String) argument.get("id")));
		return personRepository.getOne((String) argument.get("id"));
	}
	
}
