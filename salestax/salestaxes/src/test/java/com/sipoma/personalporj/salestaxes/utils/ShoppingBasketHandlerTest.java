package com.sipoma.personalporj.salestaxes.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sipoma.personalporj.salestaxes.objects.Item;
import com.sipoma.personalporj.salestaxes.objects.ShoppingCart;

public class ShoppingBasketHandlerTest {

	@Test
	public void testPrintBasket1() {
		

		
		Item testerItem1 = new Item(1,"Book",12.49,"books",false);
		Item testerItem2 =  new Item(1,"Music CD", 14.99,"Cds",false);
		Item testerItem3 = new Item(1,"Chocolate bar", 0.85,"Medical",false);
		
		

		List<Item> Items = new ArrayList<Item>();
		Items.add(testerItem1);
		Items.add(testerItem2);
		Items.add(testerItem3);
	
		ShoppingCart myCart = new ShoppingCart("myID1", (ArrayList<Item>) Items);
		ShoppingBasketHandler myBasketHandler = new ShoppingBasketHandler(myCart);
		myBasketHandler.printShoppingBasket();
		
	}
	@Test
	public void testPrintBasket2() {
		

		
		Item testerItem1 = new Item(1,"Box of Chocolate", 10.00,"Food",true);
		Item testerItem2 =  new Item(1,"Bottle of Perfume",  47.50,"Various",true);
		
		

		List<Item> Items = new ArrayList<Item>();
		Items.add(testerItem1);
		Items.add(testerItem2);
		
		ShoppingCart myCart = new ShoppingCart("myID2", (ArrayList<Item>) Items);
		ShoppingBasketHandler myBasketHandler = new ShoppingBasketHandler(myCart);
		myBasketHandler.printShoppingBasket();
		
	}
	@Test
	public void testPrintBasket3() {
		

		
		Item testerItem1 = new Item(1,"Imported bottle of Perfume", 27.99,"Various",true);
		Item testerItem2 =  new Item(1,"Bottle of Perfume", 18.99,"Various",false);
		Item testerItem3 = new Item(1,"Packet of headache pills", 9.75,"Medical",false);
		Item testerItem4 = new Item(1,"Chocolates", 11.25,"Food",true);
		

		List<Item> Items = new ArrayList<Item>();
		Items.add(testerItem1);
		Items.add(testerItem2);
		Items.add(testerItem3);
		Items.add(testerItem4);
		ShoppingCart myCart = new ShoppingCart("myID3", (ArrayList<Item>) Items);
		ShoppingBasketHandler myBasketHandler = new ShoppingBasketHandler(myCart);
		myBasketHandler.printShoppingBasket();
		
	}

}
