package com.data.api.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.data.api.model.Person;
import com.data.api.repository.PersonRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllPeopleDataFetcher implements DataFetcher<List<Person>> {

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public List<Person> get(DataFetchingEnvironment env) { 
//		System.out.println(personRepository.findAll());
		return personRepository.findAll();
	}
	
}
