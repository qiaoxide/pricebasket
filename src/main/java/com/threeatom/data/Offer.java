package com.threeatom.data;

import java.math.BigDecimal;

public interface Offer {
	
	String getId();
	
	Item getItem();

	
	BigDecimal calculateDiscount(Basket basket);

}
