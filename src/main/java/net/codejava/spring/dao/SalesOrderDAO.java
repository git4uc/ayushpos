
package net.codejava.spring.dao;

import java.util.List;
import java.util.Set;

import net.codejava.spring.model.SalesOrder;

public interface SalesOrderDAO {
	public void updateSalesOrder(SalesOrder salesOrder);
	public Integer addSalesOrder(String orderno, List details);
	public Integer addSalesOrder(SalesOrder salesOrder);	
    public void deleteSalesOrder(int id);
    public List<SalesOrder> getSalesOrderByID(int soid) throws Exception;
 	public List<SalesOrder> getOrderByOrderNo(String orderno);
	public List<SalesOrder> listSalesOrders() throws Exception;

	
}