package pricebasket;

import java.util.Map;

import org.junit.Test;

import com.threeatom.data.Basket;
import com.threeatom.data.Item;
import com.threeatom.data.Totals;
import com.threeatom.service.BasketService;
import com.threeatom.service.ItemService;
import com.threeatom.service.impl.ServiceFactory;

public class MainTest {
	
	@Test
	public void mainTest() {
		// 准备商品,数据准备，将来这里可以替换成 xml配置
		ServiceFactory factory=ServiceFactory.getInstance();
		
		
		
		ItemService itemService=factory.getItemService();
		Map<String,Item> items=itemService.getItemsMap();
		
		// 购物栏
		Basket basket=new Basket();
		
		// 买东西
		basket.putItem(items.get("apples"));
		basket.putItem(items.get("bread"));
		basket.putItem(items.get("milk"));
		basket.putItem(items.get("apples"));
		basket.putItem(items.get("soup"));
		basket.putItem(items.get("soup"));
		
		System.out.println(basket.toString());
		
		//结算
		
		BasketService basketService=factory.getBasketService();
		Totals totals=basketService.calculateBasketTotals(basket);
		
		System.out.println(totals.toString());
	}

}
