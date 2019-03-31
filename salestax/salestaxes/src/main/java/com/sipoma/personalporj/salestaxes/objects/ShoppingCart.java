package com.sipoma.personalporj.salestaxes.objects;

import java.util.List;

import com.google.gson.annotations.Expose;


public class ShoppingCart {
	@Expose String shoppingCartId;
	@Expose private List<Item> shoppingItems;
	
	public ShoppingCart() {}
	
	public ShoppingCart(String shoppingCartId, List<Item> shoppingItems) {
		super();
		this.shoppingCartId = shoppingCartId;
		this.shoppingItems = shoppingItems;
	}
	
	public String getShoppingCartId() {
		return shoppingCartId;
	}
	public void setShoppingCartId(String shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}
	public List<Item> getShoppingItems() {
		return shoppingItems;
	}
	public void setShoppingItems(List<Item> shoppingItems) {
		this.shoppingItems = shoppingItems;
	}

	@Override
	public String toString() {
		return "ShoppingCart [shoppingCartId=" + shoppingCartId + ", shoppingItems=" + shoppingItems + "]";
	}
	
	
	
}
