package net.codejava.spring.service;

import java.util.List;

import net.codejava.spring.model.SalesOrder;
  
public interface SalesOrderService {
     
    SalesOrder findById(int id);
     
    List<SalesOrder> findByOrderNo(String orderno);
     
    Integer saveSalesOrder(SalesOrder SalesOrder);
     
    void updateSalesOrder(SalesOrder SalesOrder);
     
    void deleteSalesOrderById(int id);
 
    List<SalesOrder> findAllSalesOrders(); 
     
    void deleteAllSalesOrders();
     
    public boolean isSalesOrderExist(SalesOrder SalesOrder);
     
}