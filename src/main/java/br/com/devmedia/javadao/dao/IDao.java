package br.com.devmedia.javadao.dao;

import java.util.List;
import java.util.Map;

import org.bson.Document;

public interface IDao {

	void save(Map<String, Object> mapEntity);

	void update(Map<String, Object> mapQuery, Map<String, Object> mapEntity);

	void delete(Map<String, Object> mapEntity);

	Document findOne(Map<String, Object> mapEntity);

	List<Document> findAll();

	List<Document> findKeyValue(Map<String, Object> keyValue);

}
