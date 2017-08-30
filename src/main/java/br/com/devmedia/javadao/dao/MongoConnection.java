package br.com.devmedia.javadao.dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

	private static final String HOST = "localhost";
	private static final int PORT = 27017;
	private static final String DB_NAME = "simple-mongodb";

	private static MongoConnection uniqInstance;
	private static int mongoInstance = 1;

	private MongoClient mongoClient;
	private MongoDatabase database;

	private MongoConnection() {
	}

	public static synchronized MongoConnection getInstance() {
		if (uniqInstance == null) {
			uniqInstance = new MongoConnection();
		}

		return uniqInstance;
	}

	public MongoDatabase getDB() {
		if (mongoClient == null) {
			try {
				mongoClient = new MongoClient(HOST, PORT);
				database = mongoClient.getDatabase(DB_NAME);

				System.out.println("Mongo instance equals :> " + mongoInstance++);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return database;
	}

}
