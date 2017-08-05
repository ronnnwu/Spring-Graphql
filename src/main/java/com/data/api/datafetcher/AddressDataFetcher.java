package com.data.api.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.data.api.model.Address;
import com.data.api.model.Person;
import com.data.api.repository.AddressRepository;
import com.data.api.repository.PersonRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AddressDataFetcher implements DataFetcher<List<Address>>{
 
	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public List<Address> get(DataFetchingEnvironment env) { 
		Person person = (Person) env.getSource(); 
		return addressRepository.getAddress(person.getId());
	}

}
