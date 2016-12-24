package com.ds.training.rest.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ds.training.rest.pojo.People;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/people")
public class PeopleController {

	//CRUD exmaple -- Create, Read, Update and Delete
	@Autowired
	private ObjectMapper objMapper;
	
	private Map<String, People> peopleMap = new HashMap<>();
	
	{
		People people1 = new People("Chen", "Wang");
		People people2 = new People("Min", "Wei");
		peopleMap.put("1", people1);
		peopleMap.put("2", people2);
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public Collection<People> findAll(){
		return peopleMap.values();
	}
	
	@RequestMapping(value="/{key}", method=RequestMethod.GET)
	public People findByKey(@PathVariable String key){
		return peopleMap.get(key);
	}
	
	@RequestMapping(method=RequestMethod.POST) 
	public void create(@RequestBody People people) throws IOException{
		peopleMap.put(String.valueOf(peopleMap.size() + 1), people);
	}
	
	@RequestMapping(value="/{key}", method=RequestMethod.DELETE)
	public void delete(@PathVariable String key){
		peopleMap.remove(key);
	}
}
