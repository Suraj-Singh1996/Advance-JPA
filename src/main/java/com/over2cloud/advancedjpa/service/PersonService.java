/**
 * 
 */
package com.over2cloud.advancedjpa.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.over2cloud.advancedjpa.dao.PersonDao;
import com.over2cloud.advancedjpa.model.Person;

/**
 * @author Suraj.Singh
 *
 */

@Service
public class PersonService {
	
	@Autowired
	private PersonDao pesronDao;
	
	// SaveAll
	public Iterable<Person> saveAllPersons(Iterable<Person> personsData){
		return pesronDao.saveAll(personsData);
		
	}
	
	// Find all By ID
	public Iterable<Person> findAllPerson(Iterable<Integer> personIds){
		
		return pesronDao.findAllById(personIds);
	}
	
	// Derived Method Section
	
	public List<Person> findByFirstName(String firstName)
	{
		return pesronDao.findByFirstName(firstName);
	}
	
	public Person findByLastNameAndFirstName(String lastName, String firstName) 
	{
		return pesronDao.findByLastNameAndFirstName(lastName, firstName);
	}
	
	public List<Person> findByLastNameOrFirstName(String lastName, String firstName)
	{
		return pesronDao.findByLastNameOrFirstName(lastName, firstName);
	}
	
	public List<Person> findByLastNameOrderByCreatedDateDesc(String lastName)
	{
		return pesronDao.findByLastNameOrderByCreatedDateDesc(lastName);
	}
	
	public List<Person> findByAgeLessThanEqual(Integer age)
	{
		return pesronDao.findByAgeLessThanEqual(age);
	}
		
	public List<Person> findByFirstNameLike(String firstName)
	{
		return pesronDao.findByFirstNameLike(firstName);
	}
	
	public List<Person> findByLastNameAndAgeLessThanEqual(String lastName, Integer age){
		return pesronDao.findByLastNameAndAgeLessThanEqual(lastName,age);
	}
	
	public List<Person> findByCreatedDateBetween(Date startDate, Date endDate){
		return pesronDao.findByCreatedDateBetween(startDate, endDate);
	}

	public List<Person> findByEmail(String email){
		return pesronDao.findByEmail(email);
	}
}
