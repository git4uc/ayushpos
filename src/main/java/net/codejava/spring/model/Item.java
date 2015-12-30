package net.codejava.spring.model;

public class Item {
    private int id;
	private String code ;
	private String name;
	private long price;
	private int stock;
	private long tax;
	private long discount;
	private String brandname;
	private String companyname;
	private String catalogue;
	private String remarks;
	private String updatedby;
	private String updatedone;
	private boolean discontinued;
	private String reasondiscont;
	private Category category;
	//private String image;
	
	public Item() {
	}
	

	public Item(int itemid) {
		this.id=itemid;
	}


	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getPrice() {
		return price;
	}


	public void setPrice(long price) {
		this.price = price;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}




	public long getTax() {
		return tax;
	}


	public void setTax(long tax) {
		this.tax = tax;
	}


	public long getDiscount() {
		return discount;
	}


	public void setDiscount(long discount) {
		this.discount = discount;
	}


	public String getBrandname() {
		return brandname;
	}


	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}


	public String getCompanyname() {
		return companyname;
	}


	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}


	public String getCatalogue() {
		return catalogue;
	}


	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public String getUpdatedby() {
		return updatedby;
	}


	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}


	public String getUpdatedone() {
		return updatedone;
	}


	public void setUpdatedone(String updatedone) {
		this.updatedone = updatedone;
	}


	public boolean isDiscontinued() {
		return discontinued;
	}


	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}


	public String getReasondiscont() {
		return reasondiscont;
	}


	public void setReasondiscont(String reasondiscont) {
		this.reasondiscont = reasondiscont;
	}

	
	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}
}
