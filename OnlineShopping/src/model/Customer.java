package model;

import java.util.*;

public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private double balance;
	private List<Order> order;
	public Customer(int id,String firstName, String lastName, String username, String password, double balance) {
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.balance = balance;
		order = new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	public String fullName() {
		return firstName+" "+lastName;
	}
	@Override
	public String toString() {
		return "Name=" + fullName() +  "\nusername=" + username + "\npassword="
				+ password + "\nbalance=" + balance;
	}
	

}
