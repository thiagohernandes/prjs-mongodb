package com.br.mongo.connect;

import java.util.Arrays;

import com.br.mongo.domain.Pessoa;
import com.br.mongo.util.UtilDB;
import com.mongodb.client.MongoCollection;

public class C01MongoDBInsert {

	public static void main(String...$$) {
		try {
			UtilDB util = new UtilDB();
			@SuppressWarnings("unchecked")
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
