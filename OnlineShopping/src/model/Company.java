package model;

import java.util.*;

public class Company {
	private String companyName;
	private List<Order> order;
	private List<Item> items;
	public Company(String companyName) {
		super();
		this.companyName = companyName;
		order = new ArrayList<>();
		items = new ArrayList<>();
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Company= " + companyName + "\nItems= " + items;
	}
	

}
