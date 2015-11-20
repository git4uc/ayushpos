package net.codejava.spring.model;


	import javax.persistence.*;

	@Entity
	@Table(name = "CATEGORY")
	public class Category {
		
		public Category() {
		}
		
	   @Id @GeneratedValue
	   @Column(name = "id")
	   private int id;

	   @Column(name = "name")
	   private String name;

	   @Column(name = "descp")
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

