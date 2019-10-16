package com.threeatom.service;

import java.util.List;
import java.util.Map;

import com.threeatom.data.Item;
import com.threeatom.data.Offer;

public interface ItemService {
	
	
	/**
	 * 获取商品
	 * @param name
	 * @return
	 */
	Item getItem(String name);
	
	/**
	 * 获得商品的打折数据
	 * @param item
	 * @return
	 */
	List<Offer> getOffers(Item item);
	/**
	 * 给商品添加打折对象
	 * @param key
	 * @param offer
	 */
	void addOffer(String key,Offer offer);
	
	/**
	 * 得到数据单
	 * @return
	 */
	public Map<String, Item> getItemsMap();

}
