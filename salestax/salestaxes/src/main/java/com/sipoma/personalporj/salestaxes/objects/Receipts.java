package com.sipoma.personalporj.salestaxes.objects;

import com.google.gson.annotations.Expose;
import com.sipoma.personalporj.salestaxes.utils.ShoppingBasketHandler;


public class Receipts {
	
	@Expose ShoppingCart shoppingCart;
	@Expose double salesTaxes;
	@Expose double total;
	
	private transient ShoppingBasketHandler myBasketHandler ;
	
	public Receipts(ShoppingCart myCart) {
		shoppingCart = myCart;
		myBasketHandler = new ShoppingBasketHandler(shoppingCart);
	}
	
	public double getSalesTaxes() {
		return salesTaxes;
	}
	public void setSalesTaxes(double salesTaxes) {
		this.salesTaxes = salesTaxes;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	public void printReceipts() {
		myBasketHandler.printShoppingBasket();
		salesTaxes = myBasketHandler.getTotalTaxes();
		total = myBasketHandler.getTotalPrice();
	}
	
	
}
