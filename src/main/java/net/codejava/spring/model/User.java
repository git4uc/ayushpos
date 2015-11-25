package net.codejava.spring.model;

import net.codejava.spring.model.User;



public class User {
	
    private long id;
     
    private String accountid;
    
    private String username;
    
    private String phone;
     
    private String address;
     
    private String email;
    
    private int age;
     
    public User(){
        id=0;
    }
     
    public User(long id, String username, String address, String email,int age, String accountid, String phone){
        this.id = id;
        this.username = username;
        this.address = address;
        this.email = email;
        //new field
        this.age = age;
        this.accountid = accountid;
        this.phone = phone;
    }
 
    public String getPhone() {
        return phone;
    }
 
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    public String getAccountid() {
        return accountid;
    }
 
    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }
    
    
    public int getAge() {
        return age;
    }
 
    public void setAge(int age) {
        this.age = age;
    }
 
    
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        if (id != other.id)
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", address=" + address
                + ", email=" + email + ", age=" + age + " accountid=" + accountid + " phone'" + phone + "]";
    }
     
 
}
