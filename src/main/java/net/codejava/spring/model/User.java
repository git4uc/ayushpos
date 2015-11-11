package net.codejava.spring.model;

public class User {
	private int id;
	private String username;
	private String password;
	private String email;

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

}