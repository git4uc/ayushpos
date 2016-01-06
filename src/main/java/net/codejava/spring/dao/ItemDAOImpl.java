package net.codejava.spring.dao;

import java.util.Iterator;
import java.util.List;

import net.codejava.spring.model.Item;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

public class ItemDAOImpl implements ItemDAO {
	private SessionFactory sessionFactory;
    private Session session ;
	public ItemDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Transactional
	public List<Item> listorg() {
		@SuppressWarnings("unchecked")
		List<Item> listItem = (List<Item>) sessionFactory.
		getCurrentSession().
		createCriteria(Item.class).
		setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listItem;
	}
	
 
	
	
	@SuppressWarnings("unchecked")
	public List<Item> getItemByName(String name) throws Exception{
		//call test.GetItemByID(1) in toad
		session = sessionFactory.openSession();
		try{
		Query query = session.createSQLQuery(
				"call GetItemByName(:name)")
				.addEntity(Item.class)
				.setParameter("name", name);
			List<Item> result = query.list();
			for(int i=0; i<result.size(); i++){
				Item Item = result.get(i);
				System.out.println(Item.getName());
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
	public List<Item> list() throws Exception{
		System.out.println("List : Item method");
		session = sessionFactory.openSession();
		try{
			System.out.println("Calling get all items");
	    	            Query q = session.createSQLQuery(
	    				"call GetAllItems()")
	    				.addEntity(Item.class)
	    				;
	    			for(Iterator<Item> iterator = q.list().iterator(); iterator.hasNext();){
	    				Item Item = iterator.next();
	    				System.out.println(Item.getName());
	    			}
		return q.list();
		}catch(Exception e){
			throw e;
		}finally{
			session.clear();
		   session.close();
			
		}
		
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public Item getItemByID(int id) throws Exception {
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery(
				"call GetItemByID(:id)")
				.addEntity(Item.class)
				.setParameter("id", id);
			
			List<Item> result= query.list();
			if((result!=null && result.size()>0)) return (Item) result.get(0);
		return null;
	}

	public void updateItem(Item Item) {
        Transaction trns = null;

        session = sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            session.update(Item);
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
	
    public void deleteItem(int Itemid) {
        Transaction trns = null;
        session = sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            Item Item = new Item(Itemid);
            session.delete(Item);
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
    
    
    public void addItem(Item Item) {
        Transaction trns = null;
        Session session = sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            session.save(Item);
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
	public Object getItemByCode(String code) {
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery(
				"call GetItemByCode(:code)")
				.addEntity(Item.class)
				.setParameter("code", code);
			List<Item> result= query.list();
			if(!(result==null)) return (Item) result.get(0);
		return null;
	}


	@Override
	public List<Item> getItemByCatname(String catname) {
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery(
				"call GetItemByCatname(:name)")
				.addEntity(Item.class)
				.setParameter("name", catname);
			List<Item> result= query.list();
			if(!(result==null)) return (result);
		return null;
	}




    
}
