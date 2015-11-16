package net.codejava.spring.dao;

import java.util.Iterator;
import java.util.List;

import net.codejava.spring.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

public class UserDAOImpl implements UserDAO {
	private SessionFactory sessionFactory;
    private Session session ;
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Transactional
	public List<User> listorg() {
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) sessionFactory.
		getCurrentSession().
		createCriteria(User.class).
		setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}
	
 
	
	
	public List<User> getUserByName(String name) throws Exception{
		//call test.GetUserByID(1) in toad
		session = sessionFactory.openSession();
		try{
		Query query = session.createSQLQuery(
				"call GetUserByName(:name)")
				.addEntity(User.class)
				.setParameter("name", name);
						
			List<User> result = query.list();
			for(int i=0; i<result.size(); i++){
				User user = result.get(i);
				System.out.println(user.getUsername());
			}
		return result;
		}catch(Exception e){
			throw e;
		}finally{
			session.clear();
		   session.close();
			
		}
	}
	
	@Transactional
	public List<User> list() throws Exception{
		session = sessionFactory.openSession();
		try{
	    	            Query q = session.createSQLQuery(
	    				"call GetAllUsers()")
	    				.addEntity(User.class)
	    				;
	    			for(Iterator<User> iterator = q.list().iterator(); iterator.hasNext();){
	    				User user = iterator.next();
	    				System.out.println(user.getUsername());
	    			}
		return q.list();
		}catch(Exception e){
			throw e;
		}finally{
			session.clear();
		   session.close();
			
		}
		
	}
	

	@Override
	public User getUserByID(int id) throws Exception {
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery(
				"call GetUserByID(:id)")
				.addEntity(User.class)
				.setParameter("id", id);
			List<User> result= query.list();
			if(!(result==null)) return (User) result.get(0);
		return null;
	}

	public void updateUser(User user) {
        Transaction trns = null;

        session = sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            session.update(user);
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
	
    public void deleteUser(int userid) {
        Transaction trns = null;
        session = sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            User user = new User(userid, null, null, null);
            session.delete(user);
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
    
    
    public void addUser(User user) {
        Transaction trns = null;
        Session session = sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            session.save(user);
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




    
}
