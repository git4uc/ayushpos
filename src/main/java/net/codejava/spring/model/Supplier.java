package net.codejava.spring.model;


	public class Supplier {
		
		public Supplier() {
		}
		

	   private int id;


	   private String name;


	   private String descp;
	   
	   private String  phone;
	   private String phone2;
	   private String address1;
	   private String address2;
	   private String address3;
	   


	   public Supplier(int supid) {}
	   public int getId() {
	      return id;
	   }
	   public void setId( int id ) {
	      this.id = id;
	   }
	   public String getName() {
	      return name;
	   }
	   public void setName( String supname ) {
	      this.name = supname;
	   }
	   public String getDescp() {
	      return descp;
	   }
	   public void setDescp( String supdescp ) {
	      this.descp = supdescp;
	   }
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
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

	}

