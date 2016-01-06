package net.codejava.spring.dao;


import java.util.List;

import net.codejava.spring.model.Supplier;

public interface SupplierDAO {
	public List<Supplier> list() throws Exception;
	public void updateSupplier(Supplier cate);
	public void addSupplier(Supplier cate);	
    public void deleteSupplier(int id);
    public List<Supplier> getSupplierByName(String name) throws Exception;
    public Supplier getSupplierByID(int id) throws Exception;
}
