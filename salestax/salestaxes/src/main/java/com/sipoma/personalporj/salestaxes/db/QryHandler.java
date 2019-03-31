package com.sipoma.personalporj.salestaxes.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.sipoma.personalporj.salestaxes.objects.Item;
import com.sipoma.personalporj.salestaxes.objects.ShoppingCart;

public class QryHandler {

	/**
	 * Author: SiPoma
	 */
	final static Logger logger = LoggerFactory.getLogger(QryHandler.class);

	//private MongoDatabase db;
	private DBConnector dbConnector;
	
	public QryHandler( DBConnector _dbConnector) {
		
		dbConnector = _dbConnector;
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	private Iterator<Document> execQuery( String key, String value){
		
		MongoCollection<Document> collection = dbConnector.getCollection();
		Bson filt = Filters.eq(key, value);
		System.out.println(filt);
		FindIterable<Document> fi = collection.find(filt);      
		MongoCursor<Document> cursor = fi.iterator();

		//DBObject query = new BasicDBObject(key, value);
		//DBCursor cursor =  collection.find(query);
		
		return cursor;
		
	}
	
	public String[] getDocuments( String key, String value){
		
		Iterator<Document> resultsSet = execQuery(key, value);
		
		String[] o = null;
		List<String> results = new ArrayList<String>();
		
		
		while(resultsSet.hasNext()) 
		{
			 results.add( resultsSet.next().toJson());
		}

		o = new String[results.size()];
		results.toArray(o);
		return o;
		
	}
	
	public ShoppingCart[] getCarts( String key, String value){
		
		Iterator<Document> resultsSet = execQuery(key, value);
		
		Document myDoc;

		List<ShoppingCart> carts= new ArrayList<ShoppingCart>();
		ShoppingCart cart = null;
		//List<String> results = new ArrayList<String>();
		
		logger.debug("################Found Document###################");
		
		while(resultsSet.hasNext()) 
		{
			myDoc = resultsSet.next();
			@SuppressWarnings("unchecked")
			List<Document> myShoppingItems = (List<Document>) myDoc.get("shoppingItems");
			cart = new ShoppingCart(myDoc.getString("shoppingCartId"),documentToListOfItem(myShoppingItems));
			logger.debug("################ CART ###################");
			logger.debug(cart.toString());
		}
		
		///Controllare che succede qui

		carts.add(cart);
		return  carts.toArray(new ShoppingCart[carts.size()]);
		
	}
	
	public static List<Item> documentToListOfItem(List<Document> myShoppingItems){
		
		List<Item> shoppingItems = new ArrayList<Item>();
		
		for (Document item : myShoppingItems) {
			Item shoppingItem = new Item(
					item.getInteger("number"), 
					item.getString("name"), 
					item.getDouble("noTaxCost"), 
					item.getString("itemKind"), 
					item.getBoolean("isImported"));
			shoppingItems.add(shoppingItem);
		}
		
		return shoppingItems;
		
	}

}
