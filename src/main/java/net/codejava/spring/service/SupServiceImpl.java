package net.codejava.spring.service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 



import net.codejava.spring.dao.SupplierDAO;
import net.codejava.spring.model.Supplier;
 
@Service("SupService")
@Transactional
public class SupServiceImpl implements SupService{
     
    private static final AtomicInteger counter = new AtomicInteger();
     
    private static List<Supplier> Suppliers;
    
	@Autowired
	private SupplierDAO SupplierDao;
     
      public List<Supplier> findAllSuppliers() {
        return populateDummySuppliers();
    }
     
    public Supplier findById(int id) {
    	try {
			return SupplierDao.getSupplierByID(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
     
    public List<Supplier> findByName(String name) {
        
    	try {
			return SupplierDao.getSupplierByName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
     
    
    public void saveSupplier(Supplier Supplier) {
       // Supplier.setId(counter.incrementAndGet());
        SupplierDao.addSupplier(Supplier);
    }
 
    public void updateSupplier(Supplier Supplier) {
    	SupplierDao.updateSupplier(Supplier);
    }
 
    public void deleteSupplierById(int id) {
    	SupplierDao.deleteSupplier(id);
  
    }
 
    public boolean isSupplierExist(Supplier Supplier) {
      return findByName(Supplier.getName())!=null;
    }
     
 

	public void deleteAllSuppliers(){
      //  Suppliers.clear();
    }
 
    private 
    List<Supplier> populateDummySuppliers(){
 		List<Supplier> listSuppliers = null;
		try {
			listSuppliers = SupplierDao.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/**        Suppliers.add(new Supplier(counter.incrementAndGet(),"Sam", "NY", "sam@abc.com",35,434223,"415-241-2404"));
        Suppliers.add(new Supplier(counter.incrementAndGet(),"Tomy", "ALBAMA", "tomy@abc.com",26,34324234,"415-241-2404"));
        Suppliers.add(new Supplier(counter.incrementAndGet(),"Kelly", "NEBRASKA", "kelly@abc.com",28,23423423,"415-241-2404"));
 **/       
        return listSuppliers;
    }
 
   // @ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/applicationContext.xml"})
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");
        
        
        SupService itmImpl = (SupService) context.getBean("supService");
        Supplier Supplier = new Supplier(23);
        Supplier.setName("AmmasKitchen");
        Supplier.setDescp("SecondSupplier");
        if(!itmImpl.isSupplierExist(Supplier))
    	      itmImpl.saveSupplier(Supplier); 
        else
        	System.out.println("Supplier already exists");
       Supplier Supplier1 = itmImpl.findById(29); //1
        Supplier1.setName("Update");
        itmImpl.updateSupplier(Supplier1);
    	List<Supplier> Suppliers1 = itmImpl.findByName("New"); 
       List<Supplier> Suppliers = itmImpl.findAllSuppliers();
    	for(Supplier itm1 : Suppliers){
    		System.out.println(itm1.getName());
    		//System.out.println(usr1.getPrice());
    	}
    	/**Supplier.setEmail("New Email update.com");
    	usrImpl.updateSupplier(Supplier);
    	Supplier.setId(2);
    	usrImpl.deleteSupplierById(Supplier.getId()); **/
    	System.exit(0);
    }

	
}