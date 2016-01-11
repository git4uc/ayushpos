package net.codejava.spring.dao;

import java.util.Iterator;
import java.util.List;









import net.codejava.spring.model.Category;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

public class CategoryDAOImpl implements CategoryDAO {
	private SessionFactory sessionFactory;
    private Session session ;
	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Category> getCategoryByName(String name) throws Exception{
		session = sessionFactory.openSession();
		try{
		Query query = session.createSQLQuery(
				"call GetCatByName(:name)")
				.addEntity(Category.class)
				.setParameter("name", name);
						
			List<Category> result = query.list();
			if( result.size() ==0 ) return null;
			for(int i=0; i<result.size(); i++){
				Category cat = result.get(i);
				System.out.println(cat.getName());
			}
		return result;
		}catch(Exception e){
			throw e;
		}finally{
			session.clear();
		   session.close();
			
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Category> list() throws Exception{
		session = sessionFactory.openSession();
		try{
	    	            Query q = session.createSQLQuery(
	    				"call GetAllCats()")
	    				.addEntity(Category.class)
	    				;
	    			for(Iterator<Category> iterator = q.list().iterator(); iterator.hasNext();){
	    				Category cat = iterator.next();
	    				System.out.println(cat.getDescp());
	    			}
		return q.list();
		}catch(Exception e){
			throw e;
		}finally{
			session.clear();
		   session.close();
			
		}
		
	}
	


	public void updateCategory(Category cat) {
        Transaction trns = null;

        session = sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            session.update(cat);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
                //TODO throw the exception 
            }
            e.printStackTrace();
        } finally {
        	session.clear();
            session.flush();
            session.close();
        }
    }
	
    public void deleteCategory(int catid) {
        Transaction trns = null;
        session = sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            Category cat = new Category(catid);
            cat.setId(catid);
            session.delete(cat);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
        	session.clear();
            session.flush();
            session.close();
        }
    }
    
    
    public void addCategory(Category cat) {
        Transaction trns = null;
        Session session = sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            session.save(cat);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
        	session.clear();
            session.flush();
            session.close();
        }
    }



	@SuppressWarnings("unchecked")
	@Override
	public Category getCategoryByID(int id) throws Exception {
			session = sessionFactory.openSession();
			try{
			Query query = session.createSQLQuery(
					"call GetCatById(:id)")
					.addEntity(Category.class)
					.setParameter("id", id);
							
				List<Category> result = query.list();
				//for(int i=0; i<result.size(); i++){
					Category cat = result.get(0);
					System.out.println(cat.getName());
				//}
			return cat;
			}catch(Exception e){
				throw e;
			}finally{
				session.clear();
			   session.close();
				
			}
		}
	}






    

