package com.threeatom;



import com.threeatom.data.Basket;
import com.threeatom.data.Item;
import com.threeatom.data.Totals;
import com.threeatom.service.BasketService;
import com.threeatom.service.ItemService;
import com.threeatom.service.impl.ServiceFactory;

public class PriceBasket {
	
	public static void main(String[] args) {
		
		//java -jar pricebasket-0.0.1-SNAPSHOT.jar apples bread Soup Soup apples
		
		if (args == null || args.length == 0) {
			printUsage();
			System.exit(0);
		}
		
		// 准备商品,数据准备，将来这里可以替换成 xml配置
		ServiceFactory factory=ServiceFactory.getInstance();
		ItemService itemService=factory.getItemService();
		
		// 购物栏
		Basket basket=new Basket();
		
		
		for (String itemName : args) {
			Item item = itemService.getItem(itemName);
			if (item == null) {
				continue; // skip invalid items
			}
			basket.putItem(item);
		}
		
		
		
		
		System.out.println(basket.toString());
		
		//结算
		
		BasketService basketService=factory.getBasketService();
		Totals totals=basketService.calculateBasketTotals(basket);
		
		System.out.println(totals.toString());
		
		
		
		
		
	}
	
	private static void printUsage() {
		System.out.println("Usage: java -jar pricebasket-0.0.1-SNAPSHOT.jar [items]\n"
				+ "eg. java -jar pricebasket-0.0.1-SNAPSHOT.jar Apple Milk Bread");

	}

	
	
	

}
