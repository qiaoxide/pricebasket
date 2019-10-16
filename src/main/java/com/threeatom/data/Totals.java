package com.threeatom.data;

import java.math.BigDecimal;
import java.util.Map;

public class Totals {
	
	private BigDecimal subTotal;
	
	private Map<Offer,BigDecimal> offerTotals;
	
	private BigDecimal total;

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public Map<Offer, BigDecimal> getOfferTotals() {
		return offerTotals;
	}

	public void setOfferTotals(Map<Offer, BigDecimal> offerTotals) {
		this.offerTotals = offerTotals;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	public BigDecimal calculateTotals(Basket basket) {
		
		BigDecimal offerTotal=new BigDecimal(0.0f);
		for(Offer offer:this.offerTotals.keySet()) {
			BigDecimal offerNum=this.offerTotals.get(offer);
			if(!offerNum.equals(BigDecimal.ZERO)) {
				Item item=offer.getItem();
				Integer number= basket.getItems().get(item);
				if(number!=null) {
					BigDecimal a=offerNum.multiply(item.getPrice());
					BigDecimal b=a.multiply(new BigDecimal(number));
					offerTotal=offerTotal.add(b);
				}
							
			}
		}
		this.total=this.subTotal.subtract(offerTotal);
		return this.total;
				
				
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		buffer.append(String.format("Subtotal:$[%.2f]\n", this.subTotal));
		for(Offer offer:this.offerTotals.keySet()) {
			BigDecimal offerNum=this.offerTotals.get(offer);
			if(!offerNum.equals(BigDecimal.ZERO))
				buffer.append(String.format("%s %d%% off 每个-%.2f元   ", offer.getId(),offerNum.multiply(new BigDecimal(100.0f)).intValue(),offerNum.multiply(offer.getItem().getPrice()).floatValue()));
			
		}
		buffer.append("\n");
		buffer.append(String.format("Total:$[%.2f]\n", this.total));
		return buffer.toString();
	}
	
	
	

}
