package com.threeatom.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.threeatom.data.Item;
import com.threeatom.data.ItemOffer;
import com.threeatom.data.Offer;
import com.threeatom.service.ItemService;
import com.threeatom.util.ValidateUtil;

public class ItemServiceImpl implements ItemService{
	
	
	Map<String,Item> items;
	
	Map<String,Offer> offers;
	
	
	
	public ItemServiceImpl() {
		// TODO Auto-generated constructor stub
		this.getItemsMap();
		this.getOffersMap();
		
	}
	
	public Map<String,Offer> getOffersMap(){
		if(offers!=null) {
			return this.offers;
		}
		//苹果的折扣定义
		ItemOffer applesOffer=new ItemOffer("applesOffer",new BigDecimal(0.1),this.items.get("apples"));
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
		Date date=null;
		try {
			date = df.parse("2019-10-20 00:00:00:000");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		applesOffer.setExpiryDate(date);
		
		//面包的折扣定义
		ItemOffer breadOffer=new ItemOffer("breadOffer", new BigDecimal(0.5), this.items.get("bread"));
		//定义打折规则
		Map<Item,Integer> requiredItems=new HashMap<Item, Integer>();
		requiredItems.put(this.items.get("soup"), new Integer(2));
		breadOffer.setRequiredItems(requiredItems);
		
		offers=new HashMap<String, Offer>();
		offers.put("applesOffer", applesOffer);
		offers.put("breadOffer", breadOffer);
		
		return offers;
		
		
		
	}
	
	public Map<String, Item> getItemsMap() {
		// TODO Auto-generated method stub
		
		if(items!=null) {
			return this.items;
		}
		
		Item soup=new Item("Soup",new BigDecimal(0.65));
		Item bread=new Item("Bread",new BigDecimal(0.80));
		Item milk=new Item("Milk",new BigDecimal(1.30));
		Item apples=new Item("Apples",new BigDecimal(1.00));
		
		items=new HashMap<String, Item>();
		items.put("soup", soup);
		items.put("bread", bread);
		items.put("milk", milk);
		items.put("apples",apples);
		
		return items;
		
	}

	public Item getItem(String name) {
		// TODO Auto-generated method stub
		
		ValidateUtil.validateNotNull(name, "name");
		return items.get(name.toLowerCase());
	}

	public List<Offer> getOffers(Item item) {
		// TODO Auto-generated method stub
		ValidateUtil.validateNotNull(item, "item");
		// 获取商品所有的折扣
		List<Offer> offersForItem=new LinkedList<Offer>();
		for(Offer offer:offers.values()) {
			if(item.equals(offer.getItem())) {
				offersForItem.add(offer);
			}
		}
		
		return offersForItem;
	}

	public void addOffer(String key,Offer offer) {
		// TODO Auto-generated method stub
		ValidateUtil.validateNotNull(offer, "offer");
		this.offers.put(key, offer);
	}

}
