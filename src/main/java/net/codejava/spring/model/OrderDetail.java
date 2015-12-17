package net.codejava.spring.model;

public class OrderDetail {
	   private int id;
	   private int itemid; 
	   private int qty;
	   private double price;

	   public OrderDetail(int id,double pr) {
		      this.id = id;
		      this.itemid = itemid;
		      this.qty = qty;
		      this.price=pr;
		   }
	   
	   public OrderDetail() {}
	   public OrderDetail(int itemid,int qty,double pr) {
	      this.itemid = itemid;
	      this.qty = qty;
	      this.price=pr;
	   }
	   
	  
	   
	   public int getId() {
	      return id;
	   }
	   public void setId( int id ) {
	      this.id = id;
	   }

	   public boolean equals(Object obj) {
	      if (obj == null) return false;
	      if (!this.getClass().equals(obj.getClass())) return false;

	      OrderDetail obj2 = (OrderDetail)obj;
	  //    if((this.id == obj2.getId()) && (this.name.equals(obj2.getItemid())))
	  //    {
	  //       return true;
	 //     }
	      return false;
	   }
	   public int hashCode() {
	      int tmp = 0;
	    //  tmp = ( id ).hashCode();
	      return tmp;
	   }
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	}