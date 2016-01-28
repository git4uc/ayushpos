package net.codejava.spring.service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 








import net.codejava.spring.dao.CategoryDAO;
import net.codejava.spring.model.Category;
 
@Service("catService")
@Transactional
public class CatServiceImpl implements CatService{
     
    private static final AtomicInteger counter = new AtomicInteger();
     
    private static List<Category> categorys;
    
	@Autowired
	private CategoryDAO CategoryDao;
     
      public List<Category> findAllCategorys() {
        return populateDummyCategorys();
    }
     
    public Category findById(int id) {
    	try {
			return CategoryDao.getCategoryByID(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
     
    public List<Category> findByName(String name) {
        
    	try {
			return CategoryDao.getCategoryByName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
     
    
    public void saveCategory(Category Category) throws Exception {
       // Category.setId(counter.incrementAndGet());
        CategoryDao.addCategory(Category);
    }
 
    public void updateCategory(Category Category) {
    	CategoryDao.updateCategory(Category);
    }
 
    public void deleteCategoryById(int id) throws Exception {
    	try {
			CategoryDao.deleteCategory(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
  
    }
 
    public boolean isCategoryExist(Category Category) {
      return findByName(Category.getName())!=null;
    }
     
 

	public void deleteAllCategorys(){
      //  Categorys.clear();
    }
 
    private 
    List<Category> populateDummyCategorys(){
 		List<Category> listCategorys = null;
		try {
			listCategorys = CategoryDao.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/**        Categorys.add(new Category(counter.incrementAndGet(),"Sam", "NY", "sam@abc.com",35,434223,"415-241-2404"));
        Categorys.add(new Category(counter.incrementAndGet(),"Tomy", "ALBAMA", "tomy@abc.com",26,34324234,"415-241-2404"));
        Categorys.add(new Category(counter.incrementAndGet(),"Kelly", "NEBRASKA", "kelly@abc.com",28,23423423,"415-241-2404"));
 **/       
        return listCategorys;
    }
 
   // @ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/applicationContext.xml"})
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");
        
        
        CatService catImpl = (CatService) context.getBean("catService");
        Category Category = new Category(31);
             Category.setName("Snacks");
                Category.setDescp("Snacks Hot");
            	try {
                //if(!catImpl.isCategoryExist(Category))
				
						//catImpl.saveCategory(Category);
				
                	catImpl.deleteCategoryById(31);
                
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
            
    
                	   List<Category> categorys = catImpl.findAllCategorys();
            	for(Category itm1 : categorys){
            		System.out.println(itm1.getName());
            		//System.out.println(usr1.getPrice());
            	}
    	System.exit(0);
    }

    private void example(){
      ApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");
        
        
        CatService catImpl = (CatService) context.getBean("catService");
        Category Category = new Category(32);
     Category.setName("Snacks");
        Category.setDescp("Snacks Hot");
        if(!catImpl.isCategoryExist(Category))
			try {
				catImpl.saveCategory(Category);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
 //       catImpl.deleteCategoryById(32);
    	System.exit(0);
    	System.out.println("Category already exists");
    Category category1 = catImpl.findById(15); //1
    category1.setName("DLY PODI");
    catImpl.updateCategory(category1);
	List<Category> categorys1 = catImpl.findByName("POD"); 
   List<Category> categorys = catImpl.findAllCategorys();
	for(Category itm1 : categorys){
		System.out.println(itm1.getName());
		//System.out.println(usr1.getPrice());
	}
	/**Category.setEmail("New Email update.com");
	usrImpl.updateCategory(Category);
	Category.setId(2);
	usrImpl.deleteCategoryById(Category.getId()); **/

    }
	
}