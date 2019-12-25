package model;

import java.util.*;

public class Item {
	private String itemName;
	private List<Order> order;
	private List<Company> company;
	public Item(String itemName) {
		this.itemName = itemName;
		order = new ArrayList<>();
		company = new ArrayList<>();
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	public List<Company> getCompany() {
		return company;
	}
	public void setCompany(List<Company> company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Item Name=" + itemName + "\nOrder=" + order + "\nCompany=" + company;
	}
	
	
}
