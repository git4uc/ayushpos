package net.codejava.spring.dao;

import java.util.Iterator;
import java.util.List;









import net.codejava.spring.model.Supplier;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

public class SupplierDAOImpl implements SupplierDAO {
	private SessionFactory sessionFactory;
    private Session session ;
	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Supplier> getSupplierByName(String name) throws Exception{
		session = sessionFactory.openSession();
		try{
		Query query = session.createSQLQuery(
				"call GetSupByName(:name)")
				.addEntity(Supplier.class)
				.setParameter("name", name);
						
			List<Supplier> result = query.list();
			if( result.size() ==0 ) return null;
			for(int i=0; i<result.size(); i++){
				Supplier sup = result.get(i);
				System.out.println(sup.getName());
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
	public List<Supplier> list() throws Exception{
		session = sessionFactory.openSession();
		try{
	    	            Query q = session.createSQLQuery(
	    				"call GetAllSups()")
	    				.addEntity(Supplier.class)
	    				;
	    			for(Iterator<Supplier> iterator = q.list().iterator(); iterator.hasNext();){
	    				Supplier sup = iterator.next();
	    				System.out.println(sup.getDescp());
	    			}
		return q.list();
		}catch(Exception e){
			throw e;
		}finally{
			session.clear();
		   session.close();
			
		}
		
	}
	


	public void updateSupplier(Supplier sup) {
        Transaction trns = null;

        session = sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            session.update(sup);
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
	
    public void deleteSupplier(int supid) {
        Transaction trns = null;
        session = sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            Supplier sup = new Supplier(supid);
            session.delete(sup);
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
    
    
    public void addSupplier(Supplier sup) {
        Transaction trns = null;
        Session session = sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            session.save(sup);
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
	public Supplier getSupplierByID(int id) throws Exception {
			session = sessionFactory.openSession();
			try{
			Query query = session.createSQLQuery(
					"call GetSupById(:id)")
					.addEntity(Supplier.class)
					.setParameter("id", id);
							
				List<Supplier> result = query.list();
				//for(int i=0; i<result.size(); i++){
					Supplier sup = result.get(0);
					System.out.println(sup.getName());
				//}
			return sup;
			}catch(Exception e){
				throw e;
			}finally{
				session.clear();
			   session.close();
				
			}
		}
	}






    

