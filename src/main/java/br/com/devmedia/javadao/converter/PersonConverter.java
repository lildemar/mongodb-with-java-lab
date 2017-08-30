package br.com.devmedia.javadao.converter;

import java.util.HashMap;
import java.util.Map;

import org.bson.Document;
import org.bson.types.ObjectId;

import br.com.devmedia.javadao.entity.Person;

public class PersonConverter {

	public Map<String, Object> converterToMap(Person person) {
		Map<String, Object> mapPerson = new HashMap<String, Object>();

		mapPerson.put("firstName", person.getFirstName());
		mapPerson.put("lastName", person.getLastName());
		mapPerson.put("age", person.getAge());
        mapPerson.put("phone",
                new PhoneConverter().converterToMap(person.getPhone())
        );

        return mapPerson;
    }

	@SuppressWarnings("unchecked")
	public Person converterToPerson(Document dbo) {
		Person person = new Person();

		ObjectId id = dbo.getObjectId("_id");
		person.setId(id.toString());

		person.setFirstName(dbo.getString("firstName"));
		person.setLastName(dbo.getString("lastName"));
		person.setAge(dbo.getInteger("age"));
		
        person.setPhone(new PhoneConverter().converterToPhone(
                (Document) dbo.get("phone"))
        );

		return person;
	}
}
