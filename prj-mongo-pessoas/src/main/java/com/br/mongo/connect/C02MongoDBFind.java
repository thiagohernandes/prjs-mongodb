package com.br.mongo.connect;

import static com.mongodb.client.model.Filters.lt;

import com.br.mongo.domain.Pessoa;
import com.br.mongo.util.UtilDB;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class C02MongoDBFind {

	public static void main(String...$$) {
		try {
			UtilDB util = new UtilDB();
			@SuppressWarnings("unchecked")
			MongoCollection<Pessoa> collection =
					(MongoCollection<Pessoa>) util.getCollection(util.connectDatabase("pojo"), "pessoas", Pessoa.class);

	        try (MongoCursor<Pessoa> cur = collection.find(lt("idade", 30)).iterator()) {
	            while (cur.hasNext()) {
	            	Pessoa doc = cur.next();
	                System.out.println(doc.getNome());
	            }
	        }
	        
	        System.out.print("Tudo ok!");
		} catch(Exception e) {
			System.err.print("Erro -> " + e.getMessage());
		}
	}
}
