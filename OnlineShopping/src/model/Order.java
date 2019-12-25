package model;

import java.util.*;

public class Order {
	private Customer customer;
	private int orderNumber;
	private List<Company> company;
	private List<Item> items;
	public Order(Customer customer, int orderNumber) {
		this.customer = customer;
		this.orderNumber = orderNumber;
		company = new ArrayList<>();
		items = new ArrayList<>();
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public List<Company> getCompany() {
		return company;
	}
	public void setCompany(List<Company> company) {
		this.company = company;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Customer=" + customer + "\nOrderNumber=" + orderNumber + "\nCompany=" + company + "\nItems="
				+ items;
	}
	
	
}
