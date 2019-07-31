package com.br.mongo.connect;

import com.br.mongo.domain.Pessoa;
import com.br.mongo.util.UtilDB;
import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

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
	        collection.find().forEach(printBlock);
	        System.out.print("Tudo ok!");
		} catch(Exception e) {
			System.err.print("Erro -> " + e.getMessage());
		}
	}
}
