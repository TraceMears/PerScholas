package mears.trace.classified_ads.repositories;

import java.util.List;

import mears.trace.classified_ads.models.Item;

public interface ItemRepository {
	List<Item> showItems();
	Integer addItem(Item item);
	Boolean updateOrderStatus(Integer id, Integer status);
}
