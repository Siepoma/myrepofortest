package com.sipoma.personalporj.salestaxes.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TaxesHandler {
	final static Logger logger = LoggerFactory.getLogger(TaxesHandler.class);

	static final int basicTaxPercentage = 10;
	static final int importDutyTaxPercentage = 5;
	static final int roundPosition = 2;
	
	
	
	public double applyBasicTax(double basicPrice) {
		
		return applyTax(basicPrice, basicTaxPercentage);
		
	}
	
	public double applyImportDutyTax(double basicPrice) {
		
		return applyTax(basicPrice, importDutyTaxPercentage);
		
	}
	
	public double applyBasicAndImportDutyTax(double basicPrice) {
	
		return applyTax(basicPrice, importDutyTaxPercentage + basicTaxPercentage);
		
	}
	
	
	public double applyTax(double price, int taxKind) {
		double taxAmount = 0;
		double finalPrice = 0;
		double tax = (price * taxKind) / 100;
		
		
		taxAmount = roundMaxAtFive(tax,roundPosition);
		
//		Decommentare se si vuole l'approssimazione al più vicino e non in eccesso		
//		taxAmount = roundMax(tax,roundPosition);

		finalPrice = price + taxAmount;
		finalPrice = round(finalPrice,2);
		logger.debug("Applied tax of:  "+taxAmount+" on price: "+price+"\nResult: " + finalPrice);
		
		return finalPrice;
		
	}
	
	
	
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	//input un valore e la posizione per cui voglio arrotondare al più vicino 5 nel mio caso 2 essendo 0.05
	public static double roundAtFive(double value, int places) {
		
		int rounder = (int) (Math.pow(10, places-1) * 2);
		
		
		double rounded = Math.round(value*rounder) / (double)rounder;
		logger.debug(String.valueOf(value) + " --> "+ String.valueOf(rounded));
		
		return  rounded;
		
	}
	
	public static double roundMaxAtFive(double value, int places) {
		
		int rounder = (int) (Math.pow(10, places-1) * 2);
		
		
		double rounded = Math.ceil(value*rounder) / (double)rounder;
		logger.debug(String.valueOf(value) + " --> "+ String.valueOf(rounded));
		
		return  rounded;
		
	}
	
}
