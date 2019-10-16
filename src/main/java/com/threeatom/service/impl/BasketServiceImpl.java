package com.threeatom.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.threeatom.data.Basket;
import com.threeatom.data.Item;
import com.threeatom.data.Offer;
import com.threeatom.data.Totals;
import com.threeatom.service.BasketService;
import com.threeatom.service.ItemService;

public class BasketServiceImpl implements BasketService{

	public Totals calculateBasketTotals(Basket basket) {
		// TODO Auto-generated method stub
		
		//获取
		
		Totals total=new Totals();
		total.setSubTotal(calculateSubTotal(basket));
		total.setOfferTotals(this.calculateOfferTotals(basket));
		total.calculateTotals(basket);
		
		return total;
	}
	
	
	private BigDecimal calculateSubTotal(Basket basket) {
		
		Map<Item,Integer> map=basket.getItems();
		BigDecimal subTotal=new BigDecimal(0);
		
		for(Item item:map.keySet()) {
			Integer number=map.get(item);
			subTotal=subTotal.add(item.getPrice().multiply(new BigDecimal(number)));
		}
		return subTotal;
	}
	
	private Map<Offer,BigDecimal> calculateOfferTotals(Basket basket) {
		Map<Item,Integer> map=basket.getItems();
		Map<Offer, BigDecimal> offerTotals = new HashMap<Offer, BigDecimal>();
		ItemService itemService=ServiceFactory.getInstance().getItemService();
		
		for(Item item:map.keySet()) {
			List<Offer> offers=itemService.getOffers(item);
			for(Offer offer:offers) {
				BigDecimal offerDiscount = offer.calculateDiscount(basket);
				BigDecimal totalOfferDiscount = offerTotals.get(offer);
				if(totalOfferDiscount==null) {
					offerTotals.put(offer, offerDiscount);
				}else {
					offerTotals.put(offer, totalOfferDiscount.add(offerDiscount));
				}
				
			}
		}
		
		return offerTotals;
	}
	

}
