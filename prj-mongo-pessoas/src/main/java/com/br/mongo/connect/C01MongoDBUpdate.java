package com.br.mongo.connect;

import static com.mongodb.client.model.Filters.eq;

import com.br.mongo.domain.Pessoa;
import com.br.mongo.util.UtilDB;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Updates.*;

public class C01MongoDBUpdate {

	public static void main(String...$$) {
		try {
			UtilDB util = new UtilDB();
			@SuppressWarnings("unchecked")
			MongoCollection<Pessoa> collection =
					(MongoCollection<Pessoa>) util.getCollection(util.connectDatabase("pojo"), "pessoas", Pessoa.class);
			
			collection.updateOne(eq("nome", "Gilbrano"), combine(set("idade", 100), set("nome", "Gilbrano Bauer")));
			
	        System.out.print("Tudo ok!");
		} catch(Exception e) {
			System.err.print("Erro -> " + e.getMessage());
		}
	}
}
