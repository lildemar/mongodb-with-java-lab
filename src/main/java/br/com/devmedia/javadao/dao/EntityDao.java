package br.com.devmedia.javadao.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;


public class EntityDao<T> implements IDao {
    
    private MongoCollection<Document> dbCollection;

    public EntityDao(Class<T> persistentClass) {
        this.dbCollection = MongoConnection.getInstance()
        		.getDB()
        		.getCollection(persistentClass.getSimpleName());
    }

    protected MongoCollection<Document> getDbCollection() {
        return dbCollection;
    }

    public void save(Map<String, Object> mapEntity) {
    	Document document = new Document(mapEntity);

        dbCollection.insertOne(document);

        System.out.println("Save :> " + document);
    }

    public void update(Map<String, Object> mapQuery,
                       Map<String, Object> mapEntity) {
    	Document query = new Document(mapQuery);

    	Document entity = new Document(mapEntity);

        dbCollection.updateOne(query, entity);
    }

    public void delete(Map<String, Object> mapEntity) {
    	Document entity = new Document(mapEntity);

        dbCollection.deleteOne(entity);
    }

    public Document findOne(Map<String, Object> mapEntity) {
    	Document query = new Document(mapEntity);

        return dbCollection.find(query).first();
    }

    public List<Document> findAll() {
        List<Document> list = new ArrayList<Document>();

        MongoCursor<Document> cursor = dbCollection.find().iterator();

        while (cursor.hasNext()) {
            list.add(cursor.next());
        }

        return list;
    }

    public List<Document> findKeyValue(Map<String, Object> keyValue) {
        List<Document> list = new ArrayList<Document>();

        MongoCursor<Document> cursor = dbCollection.find(new Document(keyValue)).iterator();

        while (cursor.hasNext()) {
            list.add(cursor.next());
        }

        return list;
    }	
}
