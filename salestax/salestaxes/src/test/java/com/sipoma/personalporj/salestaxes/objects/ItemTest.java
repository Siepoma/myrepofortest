package com.sipoma.personalporj.salestaxes.objects;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemTest {

	@Test
	public void testExemption() {
		

		
		Item testerItemOk = new Item(1,"Oki",15,"Medical",false);
		Item testerItemKo = new Item(1,"D&D",30,"games",false);

		

		assertEquals(true, testerItemOk.getIsExempt());
		assertEquals(false, testerItemKo.getIsExempt());
		
	}

}
