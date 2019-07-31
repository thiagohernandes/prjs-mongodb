package com.br.mongo.connect;

import com.br.mongo.domain.Pessoa;
import com.br.mongo.util.UtilDB;
import com.mongodb.Block;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.not;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import static java.util.Arrays.asList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class C01MongoDBConnect {

	public static void main(String...$$) {
		try {
			UtilDB util = new UtilDB();
			MongoCollection<Pessoa> collection =
					(MongoCollection<Pessoa>) util.getCollection(util.connectDatabase("pojo"), "pessoas", Pessoa.class);
	        Pessoa pessoa1 = new Pessoa("Beltrano", 33);
	        Pessoa pessoa2 = new Pessoa("Ciclana", 22);
	        Pessoa pessoa3 = new Pessoa("Gilbrano", 39);
	        collection.insertMany(Arrays.asList(pessoa1,pessoa2,pessoa3));
	        System.out.print("Tudo ok!");
		} catch(Exception e) {
			System.err.print("Erro -> " + e.getMessage());
		}
	}
}
