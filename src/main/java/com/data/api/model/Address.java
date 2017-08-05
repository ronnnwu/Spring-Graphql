package com.data.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
	
	public Address(){}
	
	public Address(String id, String street, String block, String region, String country, String zip) {
		super();
		this.id = id;
		this.street = street;
		this.block = block;
		this.region = region;
		this.country = country;
		this.zip = zip;
	}
	
	@Id  //primary key
	private String id;
	
	private String street;
	private String block;
	private String region;
	private String country;
	private String zip;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", block=" + block + ", region=" + region + ", country="
				+ country + ", zip=" + zip + "]";
	}
}
