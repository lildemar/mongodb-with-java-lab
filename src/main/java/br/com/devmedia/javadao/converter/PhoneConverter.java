package br.com.devmedia.javadao.converter;

import java.util.HashMap;
import java.util.Map;

import org.bson.Document;

import br.com.devmedia.javadao.entity.Phone;

public class PhoneConverter {

	public Map<String, Object> converterToMap(Phone phone) {
		Map<String, Object> mapPhone = new HashMap<String, Object>();
		mapPhone.put("phoneNumber", phone.getPhoneNumber());
		mapPhone.put("mobileNumber", phone.getMobileNumber());

		return mapPhone;
	}

	public Phone converterToPhone(Document hashMap) {
		Phone phone = new Phone();
		phone.setPhoneNumber(hashMap.getString("phoneNumber"));
		phone.setMobileNumber(hashMap.getString("mobileNumber"));

		return phone;
	}

}
