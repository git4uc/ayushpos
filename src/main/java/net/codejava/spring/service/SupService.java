package net.codejava.spring.service;

import java.util.List;

import net.codejava.spring.model.Supplier;
  
public interface SupService {
     
    Supplier findById(int id);
     
    List<Supplier> findByName(String name);
     
    void saveSupplier(Supplier Supplier);
     
    void updateSupplier(Supplier Supplier);
     
    void deleteSupplierById(int id);
 
    List<Supplier> findAllSuppliers(); 
     
    void deleteAllSuppliers();
     
    public boolean isSupplierExist(Supplier Supplier);
     
}