package br.com.devmedia.javadao.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import br.com.devmedia.javadao.converter.PersonConverter;
import br.com.devmedia.javadao.entity.Person;

public class PersonDAO extends EntityDao<Person> {

	public PersonDAO() {
		super(Person.class);
	}

	public void save(Person person) {
		Map<String, Object> mapPerson = new PersonConverter().converterToMap(person);

		save(mapPerson);
	}

	public void update(Person oldPerson, Person newPerson) {
		Map<String, Object> query = new PersonConverter().converterToMap(oldPerson);

		Map<String, Object> map = new PersonConverter().converterToMap(newPerson);

		update(query, map);
	}

	public void delete(Person person) {
		Map<String, Object> map = new PersonConverter().converterToMap(person);

		delete(map);
	}

	public Person findPerson(Map<String, Object> mapKeyValue) {
		Document dbObject = findOne(mapKeyValue);

		Person person = new PersonConverter().converterToPerson(dbObject);

		return person;
	}

	public List<Person> findPersons() {
		List<Document> dbObject = findAll();

		List<Person> persons = new ArrayList<Person>();

		for (Document dbo : dbObject) {
			Person person = new PersonConverter().converterToPerson(dbo);

			persons.add(person);
		}

		return persons;
	}

	public List<Person> findPersons(Map<String, Object> mapKeyValue) {
		List<Document> dbObject = findKeyValue(mapKeyValue);

		List<Person> persons = new ArrayList<Person>();

		for (Document dbo : dbObject) {
			Person person = new PersonConverter().converterToPerson(dbo);

			persons.add(person);
		}

		return persons;
	}
}
