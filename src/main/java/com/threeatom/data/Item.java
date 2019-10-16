package com.threeatom.data;

import java.math.BigDecimal;

public class Item {
	
	
	private String id;
	
	private String name;
	
	private BigDecimal price;
	
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public Item(String name,BigDecimal price) {
		this.id=name;
		this.name=name;
		this.price=price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return "Item[id="+id+",price="+price+"]";
	}
	
	

}
