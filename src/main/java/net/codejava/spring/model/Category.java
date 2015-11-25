package net.codejava.spring.model;


	public class Category {
		
		public Category() {
		}
		

	   private int id;


	   private String name;


	   private String descp;


	   public Category(int catid) {}
	   public int getId() {
	      return id;
	   }
	   public void setId( int id ) {
	      this.id = id;
	   }
	   public String getName() {
	      return name;
	   }
	   public void setName( String catname ) {
	      this.name = catname;
	   }
	   public String getDescp() {
	      return descp;
	   }
	   public void setDescp( String catdescp ) {
	      this.descp = catdescp;
	   }

	}

