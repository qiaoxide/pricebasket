package com.threeatom.data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class ItemOffer implements Offer{
	
	
	private String id;
	private BigDecimal discount;
	private Item item;
	private Date expiryDate;
	
	
	private Map<Item,Integer> requiredItems;

	
	

	public ItemOffer(String id,BigDecimal discount,Item item) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.discount=discount;
		this.item=item;
		
	}
	
	public void setId(String id) {
		this.id=id;
	}
	
	
	
	public BigDecimal getDiscount() {
		return discount;
	}



	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}



	public Date getExpiryDate() {
		return expiryDate;
	}



	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}



	public Map<Item, Integer> getRequiredItems() {
		return requiredItems;
	}



	public void setRequiredItems(Map<Item, Integer> requiredItems) {
		this.requiredItems = requiredItems;
	}



	public void setItem(Item item) {
		this.item = item;
	}



	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public Item getItem() {
		// TODO Auto-generated method stub
		return this.item;
	}

	public BigDecimal calculateDiscount(Basket basket) {
		// TODO Auto-generated method stub
		
		
		//日期满足
		if(this.expiryDate!=null) {
			if(System.currentTimeMillis()<this.expiryDate.getTime()) {
				
				return this.discount;
			}
		}

		if(this.requiredItems==null) {
			return this.discount;
		}
		
		//看看是否符合要求
		for(Item item:this.requiredItems.keySet()) {
			Integer number=basket.getItems().get(item);
			if(number!=null) {
				if(this.requiredItems.get(item)>number) {
					return new BigDecimal(0.0f);
				}
			}else {
				return new BigDecimal(0.0f);
			}
			
		}
		
		return this.discount;
	}

}
