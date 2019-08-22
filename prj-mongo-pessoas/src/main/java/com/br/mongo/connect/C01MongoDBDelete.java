package com.br.mongo.connect;

import static com.mongodb.client.model.Filters.eq;

import com.br.mongo.domain.Pessoa;
import com.br.mongo.util.UtilDB;
import com.mongodb.client.MongoCollection;

public class C01MongoDBDelete {

	public static void main(String...$$) {
		try {
			UtilDB util = new UtilDB();
			@SuppressWarnings("unchecked")
			MongoCollection<Pessoa> collection =
					(MongoCollection<Pessoa>) util.getCollection(util.connectDatabase("pojo"), "pessoas", Pessoa.class);
			
			collection.deleteOne(eq("nome", "Apagar"));
			
	        System.out.print("Tudo ok!");
		} catch(Exception e) {
			System.err.print("Erro -> " + e.getMessage());
		}
	}
}
