package kr.or.ddit.creational.builder;

import java.util.*;

public class Meal {
	private List<Item> items = new ArrayList<Item>();
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public float getCost() {
		float cost = 0.0f;
		
		for (Item item : items) {
			cost += item.price();
		}
		return cost;
	}
	
	// 식사 항목 구성보기
	public void showItems() {
		
		for (Item item : items) {
			System.out.print("Item : "+item.name());
			System.out.print(", Packing : "+item.packing().pack());
			System.out.print(", Price : "+item.price());
			System.out.println();
		}
	}
	
	
}
