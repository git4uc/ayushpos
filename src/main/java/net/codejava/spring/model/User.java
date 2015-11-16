package net.codejava.spring.model;

import java.util.Date;

public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	private String fax;
	private String phone;
	private String address1;
	private String address2;
	private String address3;
	private String cardno;
	private Date cardexpdt;


	
	

	public User() {

	}
	
	public User(int id, String name, String password,String email) {
		this.id = id;
		this.username=name;
		this.password=password;
		this.email=email;
	}

	public int getId() {
		return id;
	}

	public void setId(int l) {
		this.id = l;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public Date getCardexpdt() {
		return cardexpdt;
	}

	public void setCardexpdt(Date cardexpdt) {
		this.cardexpdt = cardexpdt;
	}

}
