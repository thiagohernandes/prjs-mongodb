package com.br.mongo.connect;

import com.br.mongo.domain.Pessoa;
import com.br.mongo.util.UtilDB;
import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import static com.mongodb.client.model.Filters.lt;

import org.bson.Document;

public class C02MongoDBFind {

	public static void main(String...$$) {
		try {
			UtilDB util = new UtilDB();
			MongoCollection<Pessoa> collection =
					(MongoCollection<Pessoa>) util.getCollection(util.connectDatabase("pojo"), "pessoas", Pessoa.class);

			Block<Pessoa> printBlock = new Block<Pessoa>() {
	            @Override
	            public void apply(final Pessoa pessoa) {
	                System.out.println(pessoa.getNome() + " - " + pessoa.getIdade());
	            }
	        };
	        collection.find(lt("idade", 30)).forEach(printBlock);
	        try (MongoCursor<Pessoa> cur = collection.find().iterator()) {
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
