package br.com.devmedia.javadao.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "person")
public class Person {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private int age;

	public Person() {}

	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String i) {
		this.id = i;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String f) {
		this.firstName = f;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String l) {
		this.lastName = l;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int a) {
		this.age = a;
	}
	
	@Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s', age='%s']",
                id, firstName, lastName, age);
    }
}

