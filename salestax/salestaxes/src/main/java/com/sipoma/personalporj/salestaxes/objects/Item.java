package com.sipoma.personalporj.salestaxes.objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.annotations.Expose;


public class Item {
	
	static final String[] exemptItems = {"books", "food", "medical"};
	final static Logger logger = LoggerFactory.getLogger(Item.class);

	@Expose int number;
	private  boolean isExempt;
	private  boolean isImported;
	private  String itemKind;
	@Expose String name;
	private  double noTaxCost;
	@Expose double taxedCost;
	


	public Item() {};
	
	public Item( int number, String name, double noTaxCost, String itemKind, boolean isImported) {
		super();
		this.itemKind = itemKind;
		this.name = name;
		this.noTaxCost = noTaxCost;
		this.isImported = isImported;
		this.isExempt = isExempt(itemKind);
		this.number = number;
	}
	
	
	public boolean getIsImported() {
		return isImported;
	}
	public void setIsImported(boolean isImported) {
		this.isImported = isImported;
	}
	public boolean getIsExempt() {
		return isExempt;
	}
	public void setIsExempt(boolean isExempt) {
		this.isExempt = isExempt;
	}
	public String getItemKind() {
		return itemKind;
	}
	public void setItemKind(String itemKind) {
		this.itemKind = itemKind;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getNoTaxCost() {
		return noTaxCost;
	}
	public void setNoTaxCost(double noTaxCost) {
		this.noTaxCost = noTaxCost;
	}
	public double getTaxedCost() {
		return taxedCost;
	}
	public void setTaxedCost(double taxedCost) {
		this.taxedCost = taxedCost;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
	static boolean isExempt(String itemKind) {
		
		boolean isExempt = false;
		int i = 0;
		while(!isExempt && i<exemptItems.length) {
			isExempt = itemKind.toUpperCase().equals(exemptItems[i].toUpperCase());
			i++;
		}
		logger.debug("Is item of kind "+itemKind+" exent of tax? " + isExempt);
		return isExempt;
	}
	
	
}
