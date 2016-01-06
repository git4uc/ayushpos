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
 
@Service("CatService")
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
     
    
    public void saveCategory(Category Category) {
       // Category.setId(counter.incrementAndGet());
        CategoryDao.addCategory(Category);
    }
 
    public void updateCategory(Category Category) {
    	CategoryDao.updateCategory(Category);
    }
 
    public void deleteCategoryById(int id) {
    	CategoryDao.deleteCategory(id);
  
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
        
        
        CatService itmImpl = (CatService) context.getBean("catService");
        Category Category = new Category(23);
        Category.setName("REALNEWE");
        Category.setDescp("Snacks Hot");
        if(!itmImpl.isCategoryExist(Category))
    	      itmImpl.saveCategory(Category); 
        else
        	System.out.println("Category already exists");
        Category category1 = itmImpl.findById(15); //1
        category1.setName("DLY PODI");
        itmImpl.updateCategory(category1);
    	List<Category> categorys1 = itmImpl.findByName("POD"); 
       List<Category> categorys = itmImpl.findAllCategorys();
    	for(Category itm1 : categorys){
    		System.out.println(itm1.getName());
    		//System.out.println(usr1.getPrice());
    	}
    	/**Category.setEmail("New Email update.com");
    	usrImpl.updateCategory(Category);
    	Category.setId(2);
    	usrImpl.deleteCategoryById(Category.getId()); **/
    	System.exit(0);
    }

	
}