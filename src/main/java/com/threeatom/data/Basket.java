package com.threeatom.data;

import java.util.HashMap;
import java.util.Map;

public class Basket {
	private Map<Item,Integer> items=new HashMap<Item,Integer>();
	
	
	
	public Map<Item, Integer> getItems() {
		return items;
	}


	public void setItems(Map<Item, Integer> items) {
		this.items = items;
	}


	public void putItem(Item item) {
		
		Integer number=items.get(item);
		
		if(number==null) items.put(item, 1);
		
		else items.put(item, ++number);
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		for(Item item:items.keySet()) {
			buffer.append(String.format("Name:[%s],Price:[%.2f],Number:[%d]\n", item.getId(),item.getPrice(),items.get(item)));
		}
		return buffer.toString();
		
	}
	
	
	

}
