package com.sipoma.personalporj.salestaxes.utils;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sipoma.personalporj.salestaxes.objects.Item;
import com.sipoma.personalporj.salestaxes.objects.ShoppingCart;

public class ShoppingBasketHandler {

	final static Logger logger = LoggerFactory.getLogger(ShoppingBasketHandler.class);
	
	public List<Item> shoppingItems;
	public ShoppingCart myCart;
	double totalTaxes = 0;
	double totalPrice = 0;
	
	TaxesHandler myTaxHandler = new TaxesHandler();

	public ShoppingBasketHandler(ShoppingCart myCart) {
		shoppingItems = myCart.getShoppingItems();
	}

	protected void applyTaxToBasket() {
		
		for(Item item : shoppingItems) {
			double basicPrice = item.getNoTaxCost();
			if(item.getIsImported()) {
				if (!item.getIsExempt()) {item.setTaxedCost(myTaxHandler.applyBasicAndImportDutyTax(basicPrice));}
				else {item.setTaxedCost(myTaxHandler.applyImportDutyTax(basicPrice));}
			}else {
				if (!item.getIsExempt()) {item.setTaxedCost(myTaxHandler.applyBasicTax(basicPrice));}
				else {item.setTaxedCost(basicPrice);}
			}
		}
	}
	
	public void printShoppingBasket(){
		
		this.applyTaxToBasket();
		for(Item item : shoppingItems) {
			double tax = item.getTaxedCost() - item.getNoTaxCost();
			int number = item.getNumber();
			logger.info(number + " " + item.getName() + " : " + String.format("%.2f",item.getTaxedCost()));
			totalTaxes += (tax * number);
			totalPrice += (item.getTaxedCost() * number);
		}
		totalTaxes = TaxesHandler.round(totalTaxes, 2); 
		totalPrice = TaxesHandler.round(totalPrice, 2);
		logger.info("Sales Taxes: " + String.format("%.2f", totalTaxes) );
		logger.info("Total: " + totalPrice);
		
	}
	
	public double getTotalTaxes() {
		return totalTaxes;
	}

	public void setTotalTaxes(double totalTaxes) {
		this.totalTaxes = totalTaxes;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	


}
