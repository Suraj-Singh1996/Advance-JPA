package com.over2cloud.advancedjpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.over2cloud.advancedjpa.model.Person;
import com.over2cloud.advancedjpa.service.PersonService;

@SpringBootApplication
public class AdvancedJpaApplication implements CommandLineRunner {

	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(AdvancedJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// createPersons();
		// getPersons();
		// findByFirstName();
		// findByFirstNameAndLastName();
		// findByFirstNameOrLastName();
		// findByEmail();
		//findByLastNameOrderByCreatedDateDesc();
		//findByAgeLessThanEqual();
		//findByFirstNameLike();
		//findByLastNameAndAgeLessThanEqual();
		findByCreatedDateBetweenWithTime();
	}

	private void createPersons() {

		List<Person> personList = Arrays.asList(new Person("Poonam", "Chauhan", "poonam@gmail.com", 20),
				new Person("Sanjana", "Chauhan", "sanju@gmail.com", 20),
				new Person("Ashwanee", "kumar", "ashwaneekumar@gmail.com", 20),
				new Person("Bhavnarushi", "Cehanuri", "rushi@gmail.com", 20),
				new Person("Pankaj", "Singh", "singh7@gmail.com", 20),
				new Person("Dheeraj", "Chauhan", "dershtiyog@gmail.com", 20),
				new Person("Signora", "koonar", "signora@gmail.com", 20),
				new Person("Sneh", "Kumari", "kumari@gmail.com", 20),
				new Person("Aditya", "Singh", "aditeya@gmail.com", 20),
				new Person("Adharsh", "Singh", "asharsh@gmail.com", 20));

		Iterable<Person> list = personService.saveAllPersons(personList);
		for (Person person : list) {
			System.out.println("Person Object" + person.toString());

		}
	}

	private void findByFirstName() {
		Iterable<Person> personsList = personService.findByFirstName("Sanjana");
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}

	private void findByFirstNameAndLastName() {
		Person person = personService.findByLastNameAndFirstName("Chauhan", "Sanjana");
		System.out.println("Person Object" + person.toString());
	}

	private void findByFirstNameOrLastName() {
		Iterable<Person> personsList = personService.findByLastNameOrFirstName("Chauhan", "Sanjana");
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}

	public void findByEmail() {
		Iterable<Person> personsList = personService.findByEmail("poonam@gmail.com");
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}

	private void findByLastNameOrderByCreatedDateDesc() {

		Iterable<Person> personList = personService.findByLastNameOrderByCreatedDateDesc("Singh");

		for (Person person : personList) {
			System.out.println("Person Object" + person.toString());
		}
	}

	private void findByAgeLessThanEqual() {

		Iterable<Person> personList = personService.findByAgeLessThanEqual(20);

		for (Person person : personList) {
			System.out.println("Person Object" + person.toString());
		}
	}
	
	private void findByFirstNameLike() {

		Iterable<Person> personList = personService.findByFirstNameLike("Pankaj");

		for (Person person : personList) {
			System.out.println("Person Object" + person.toString());
		}
	}

	private void findByLastNameAndAgeLessThanEqual() {
		Iterable<Person> personsList = personService.findByLastNameAndAgeLessThanEqual("Singh", 20);
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}
	
	private void findByCreatedDateBetweenWithTime() {
		Iterable<Person> personsList = personService.findByCreatedDateBetween(
				getDateWithTime("2022-09-30 23:47:22"),
				getDateWithTime("2022-09-30 23:50:22"));
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}
	
	private Date getDateWithTime(String dateString) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return format.parse(dateString);
		}catch (ParseException pe) {
			throw new RuntimeException(pe);
		}
	}

}
