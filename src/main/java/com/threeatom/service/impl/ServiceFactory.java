package com.threeatom.service.impl;

import com.threeatom.service.BasketService;
import com.threeatom.service.ItemService;

public class ServiceFactory {
	
	private static ServiceFactory instance=null;
	
	private static BasketService basketService;
	
	private static ItemService itemService;
	
	
	public static ServiceFactory getInstance() {
		if(instance!=null) return instance;
		instance=new ServiceFactory();
		return instance;
	}
	
	public BasketService getBasketService() {
		if(basketService!=null) return basketService;
		
		basketService=new BasketServiceImpl();
		return basketService;
	}
	
	
	public ItemService getItemService() {
		if(itemService!=null) return itemService;
		
		itemService=new ItemServiceImpl();
		return itemService;
	}

}
