package br.com.devmedia.javadao.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.devmedia.javadao.dao.PersonDAO;
import br.com.devmedia.javadao.entity.Person;
import br.com.devmedia.javadao.entity.Phone;

public class PersonTest {

	public static void main(String[] args) {
		//save();
		//update();
		delete();
	}

	public static void save() {
		Phone ph1 = new Phone("021-3222.6598", "021-9145.9966");
		Person p1 = new Person("Rodrigo", "de Alvarez", 27, ph1);

		new PersonDAO().save(p1);

		Phone ph2 = new Phone("011-3002.0590", "011-9100.9006");
		Person p2 = new Person("Manoel", "de Souza", 23, ph2);
		new PersonDAO().save(p2);

		Phone ph3 = new Phone("055-3222.2522", "055-9225.4464");
		Person p3 = new Person("Anita", "Pires de Almeida", 38, ph3);
		new PersonDAO().save(p3);

		List<Person> persons = new PersonDAO().findPersons();
		for (Person person : persons) {
			System.out.println(person.toString());
		}
	}

	public static void update() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("firstName", "Anita");
		Person query = new PersonDAO().findPerson(map);

		Phone phone = new Phone("048-3222.2522", "048-9225.4464");
		Person person = new Person("Anita", "Pires de Almeida", 30, phone);

		new PersonDAO().update(query, person);

		Person newPerson = new PersonDAO().findPerson(map);
		System.out.printf("Old:> " + query + "\nNew:> " + newPerson.toString());
	}

	public static void delete() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("firstName", "Anita");
		List<Person> query = new PersonDAO().findPersons(map);

		for (Person person : query) {
			new PersonDAO().delete(person);
		}

		List<Person> persons = new PersonDAO().findPersons();
		for (Person person : persons) {
			System.out.println(person.toString());
		}
	}

}
