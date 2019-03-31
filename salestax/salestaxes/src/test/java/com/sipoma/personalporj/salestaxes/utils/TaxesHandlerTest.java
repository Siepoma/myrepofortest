package com.sipoma.personalporj.salestaxes.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaxesHandlerTest {
	
	static final int acceptanceDelta = 0;
	@Test
	public void testTaxes() {
		TaxesHandler tester = new TaxesHandler();
		float itemBasicPrice = (float) 14.99; 
		float taxedItemBasicPrice = (float) 16.49; 
		
		float itemImportedPrice = (float) 10.00; 
		float taxedItemImportedPrice = (float) 10.50; 
		
		float itemImportedAndBasicPrice = (float) 27.99; 
		float taxedItemImportedAndBasicPrice = (float) 32.19; 

		assertEquals(taxedItemBasicPrice, tester.applyBasicTax(itemBasicPrice),acceptanceDelta);
		assertEquals(taxedItemImportedPrice, tester.applyImportDutyTax(itemImportedPrice),acceptanceDelta);
		
		assertEquals(taxedItemImportedAndBasicPrice, tester.applyBasicAndImportDutyTax(itemImportedAndBasicPrice),acceptanceDelta);


		
	}
	

}
