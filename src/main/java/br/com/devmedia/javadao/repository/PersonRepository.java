package br.com.devmedia.javadao.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.devmedia.javadao.entity.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

    public Person findByFirstName(String firstName);

    public List<Person> findByLastName(String lastName);

}
