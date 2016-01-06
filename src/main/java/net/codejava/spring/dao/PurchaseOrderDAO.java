
package net.codejava.spring.dao;

import java.util.List;
import java.util.Set;

import net.codejava.spring.model.PurchaseOrder;

public interface PurchaseOrderDAO {
	public void updatePurchaseOrder(PurchaseOrder purchaseOrder);
	public Integer addPurchaseOrder(String orderno, List details);
	public Integer addPurchaseOrder(PurchaseOrder purchaseOrder);	
    public void deletePurchaseOrder(int id);
    public List<PurchaseOrder> getPurchaseOrderByID(int soid) throws Exception;
 	public List<PurchaseOrder> getOrderByOrderNo(String orderno);
	public List<PurchaseOrder> listPurchaseOrders() throws Exception;

	
}