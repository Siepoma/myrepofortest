package com.sipoma.personalporj.salestaxes.rest;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.sipoma.personalporj.salestaxes.objects.Item;
import com.sipoma.personalporj.salestaxes.objects.ShoppingCart;



public class ShoppingCartResourceTest extends JerseyTest {

//@Mock
//private QryHandler daoMock;
//@Mock
//private DBConnector connector;


	
	
//@InjectMocks
 //private ShoppingCartResource service;

	public ShoppingCart myCart;

	@Before
	public void setUp() throws Exception {

		//MockitoAnnotations.initMocks(this);

		Item testerItem1 = new Item(1,"Imported Perfume",(float) 27.99,"Various",true);
		Item testerItem2 =  new Item(1,"Perfume",(float) 18.99,"Various",false);
		Item testerItem3 = new Item(1,"Pills",(float) 9.75,"Medical",false);
		Item testerItem4 = new Item(1,"Choco",(float) 11.25,"Food",true);


		List<Item> Items = new ArrayList<Item>();
		Items.add(testerItem1);
		Items.add(testerItem2);
		Items.add(testerItem3);
		Items.add(testerItem4);
		myCart = new ShoppingCart("myTestID", (ArrayList<Item>) Items);

	}

	@Override
	protected Application configure() {
		return new ResourceConfig(ShoppingCartResource.class);
	}



	@Test
	public void postCartRestServiceTest() {

		//String[] mockResp = {"OK"};
		//Mockito.when(daoMock.getDocuments("shoppingCartId","myTestID")).thenReturn(mockResp);

		
		Gson g = new Gson();
		
		
		String response = target("/shopping-cart/postCart")
				.request()
				.post(Entity.entity(g.toJson(myCart), MediaType.APPLICATION_JSON), String.class);
		
	

		String okRespo = "{\"resultCode\":\"200\",\"resultDescription\":\"Cart Created\"}";

		assertEquals(okRespo, response);


	}

	@Test
	public void getCartRestServiceTest() {
		
		//ShoppingCart[] mockResp =  {myCart};
		//Mockito.when(daoMock.getCarts("shoppingCartId","myTestID")).thenReturn(mockResp);

		int response = target("/shopping-cart/getCart?cartID=myTestID").request().get().getStatus();
		

		assertEquals(200, response);
	}

	@Test
	public void getReceiptsRestServiceTest() {
		//ShoppingCart[] mockResp =  {myCart};
		//Mockito.when(daoMock.getCarts("shoppingCartId","myTestID")).thenReturn(mockResp);

		int response = target("/shopping-cart/getReceipts?cartID=myTestID").request().get().getStatus();

		assertEquals(200, response);
	}
}