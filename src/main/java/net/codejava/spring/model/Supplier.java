package net.codejava.spring.model;


	public class Supplier {
		
		public Supplier() {
		}
		

	   private int id;


	   private String name;


	   private String descp;


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

	}

