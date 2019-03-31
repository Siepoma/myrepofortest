package com.sipoma.personalporj.salestaxes.db;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class DBConnector{

	/**
	 * Author SiPoma 
	 */

	
	private MongoClient mc;
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	
	
	
	
	public DBConnector() {
		super();
		createClient();
	}
	
	public DBConnector(String host, Integer port) {
		super();
		createClient(host,port);
		// TODO Auto-generated constructor stub
	}

	public MongoClient getMc() {
		return mc;
	}

	

	public MongoDatabase getDatabase(String databaseName) {
		return mc.getDatabase(databaseName);
	}
	
	public void setDatabase(String databaseName) {
		database = mc.getDatabase(databaseName);
	}

	

	public MongoCollection<Document> getCollection(/**String collectionName**/) {
		return collection;
				//database.getCollection(collectionName);
	}

	public void setCollection(String collectionName) {
		this.collection = database.getCollection(collectionName);
	}


	

	public MongoClient	createClient(String connectionURI){
		
		mc = new MongoClient(new MongoClientURI(connectionURI));
		return mc;
		
	}
	
	public MongoClient	createClient(String host, Integer port, String usr, String pwd, String db){
		
		String uri = "mongodb://" + usr + ":" + pwd + "@" + host + ":" + port + "/?authSource=" + db ;
		
		mc = new MongoClient(new MongoClientURI(uri));
		return mc;
		
	}
	

	public MongoClient	createClient(String host, Integer port, String usr, String pwd){
		
		String uri = "mongodb://" + usr + ":" + pwd + "@" + host + ":" + port;
		
		mc =  new MongoClient(new MongoClientURI(uri));
		return mc;

		
	}
	
	
	public MongoClient	createClient(String host, Integer port){
		
		mc =  new MongoClient(host,port);
		
		return mc;

		
	}
	
	public MongoClient	createClient(){
		
		mc =  new MongoClient();
		
		return mc;

		
	}
	
	public Iterator<Document> execQuery( String key, String value){
		
		FindIterable<Document> fi = collection.find(Filters.eq(key, value));      
		MongoCursor<Document> cursor = fi.iterator();

		//DBObject query = new BasicDBObject(key, value);
		//DBCursor cursor =  collection.find(query);
		
		return cursor;
		
	}
	
	
}
