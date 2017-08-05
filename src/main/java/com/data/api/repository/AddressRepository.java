package com.data.api.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.data.api.model.Address;
 

@Component
public class AddressRepository {
	
	@Value("classpath:PersonAddress.csv")
	private Resource stayAtResource; 

	@Value("classpath:Address.csv")
	private Resource addressResource;
	
	public List<Address> getAddress(String personId){
		  
		List<String> addessesIds = null;
		List<Address> addesses = null;
		
		try{
			addessesIds = getAddessesIds(personId);
			addesses = getAddesses(addessesIds);
		}catch(IOException e){
			e.printStackTrace();
		} 
		return addesses; 
	}

	private List<Address> getAddesses(List<String> addressesIds) throws IOException {
		List<Address> addesses= new ArrayList<>();
		Map<String, Address> addressMap = getAddesses();
		for (String addressId : addressesIds){
			addesses.add(addressMap.get(addressId));
		} 
		return addesses;
	}

	private Map<String, Address> getAddesses() throws IOException {
		File addressFile = addressResource.getFile();
		Scanner sc = new Scanner(addressFile);
		Map<String, Address> addresses = new HashMap<>();
		while (sc.hasNextLine()){
			String line = sc.nextLine(); 
			String[] col = line.split(","); 
			Address address = new Address(col[0],col[1],col[2],col[3],col[4],col[5]);
			addresses.put(col[0], address);
		} 
		return addresses;
	}

	private List<String> getAddessesIds(String personId) throws IOException {
		List<String> addressIds = new ArrayList<>();
		File personAddressFile = stayAtResource.getFile();
		Scanner sc = new Scanner(personAddressFile);
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			String[] col = line.split(",");
			if (col[0].equals(personId)){
				addressIds.add(col[1]);
			}
		} 
		return addressIds; 
	}
}
