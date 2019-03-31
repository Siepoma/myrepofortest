package com.sipoma.personalporj.salestaxes.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.sipoma.personalporj.salestaxes.db.DBConnector;
import com.sipoma.personalporj.salestaxes.db.QryHandler;
import com.sipoma.personalporj.salestaxes.objects.Receipts;
import com.sipoma.personalporj.salestaxes.objects.ShoppingCart;

@Path("/shopping-cart")
@Produces(MediaType.APPLICATION_JSON)
public class ShoppingCartResource {
	final static Logger logger = LoggerFactory.getLogger(ShoppingCartResource.class);

	final static String dbName = "DB_CART";
	final static String collectionName="CART_COLLECTION";
	
	final static String dbHostname="mongo";
	final static int dbPort=27017;

	
	
	ShoppingCart cart;
	Gson g;
	Gson gson; 
	
	DBConnector connector;	
	QryHandler qry;
	
	public ShoppingCartResource() {
		
    	g = new Gson();
    	gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		
		connector = new DBConnector(dbHostname,dbPort);

		connector.setDatabase(dbName);
		connector.setCollection(collectionName);
		
		qry = new QryHandler(connector);
		
		
	}
	
	
	

    
    @GET
    @Path("/getCart")
    public Response getCart(@QueryParam("cartID") String cartID) {
    	
    	logger.debug("Request Arrived");
    	logger.debug("CartID " + cartID);
    	
    	
    	
    	
    	String json = qry.getDocuments("shoppingCartId", cartID)[0];
    	logger.debug("Cart Found");
    	
    	
		
    	//String json = g.toJson(cart);
    	return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Path("postCart")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postCart( ShoppingCart cart) {
    	
    
    	String json = g.toJson(cart);
    	logger.debug(json);
    	
    	connector.getCollection().insertOne(new Document( BasicDBObject.parse(json)));
    	logger.debug("#################Cart Created####################");

    	String jsonResp = g.toJson(new Result("200","Cart Created"));
    	
    	return Response.ok(jsonResp, MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("/getReceipts")
    public Response getReceipts(@QueryParam("cartID") String cartID) {
    	
    	logger.debug("Processing new Receipts");
    	logger.debug("CartID " + cartID);
    
    	
    	
    	ShoppingCart[] carts = qry.getCarts("shoppingCartId", cartID);
    	logger.debug("################ Cart Found ################");
    	
    	
    	Receipts receipts = new Receipts(carts[0]);
    	receipts.printReceipts();
		
    	String json = gson.toJson(receipts);
    	return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }


    
}

