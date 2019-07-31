package com.br.mongo.util;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class UtilDB {
	
	public MongoDatabase connectDatabase(String nameDatabase) {
		MongoClient mongoClient;
		mongoClient = MongoClients.create("mongodb://localhost:27017");
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
	                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        return mongoClient.getDatabase(nameDatabase).withCodecRegistry(pojoCodecRegistry);
	}
	
	public MongoCollection<?> getCollection(MongoDatabase mongoDatabase, String nameCollection, Class<?> obj) {
		return mongoDatabase.getCollection(nameCollection, obj);
	}
	

}
