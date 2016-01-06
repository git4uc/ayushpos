package net.codejava.spring.service;

import java.util.List;

import net.codejava.spring.model.PurchaseOrder;
  
public interface PurchaseOrderService {
     
    PurchaseOrder findById(int id);
     
    List<PurchaseOrder> findByOrderNo(String orderno);
     
    Integer savePurchaseOrder(PurchaseOrder PurchaseOrder);
     
    void updatePurchaseOrder(PurchaseOrder PurchaseOrder);
     
    void deletePurchaseOrderById(int id);
 
    List<PurchaseOrder> findAllPurchaseOrders(); 
     
    void deleteAllPurchaseOrders();
     
    public boolean isPurchaseOrderExist(PurchaseOrder PurchaseOrder);
     
}