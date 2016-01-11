package net.codejava.spring.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
 










import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 










import net.codejava.spring.dao.UserDAO;
import net.codejava.spring.model.User;
 
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
     
    private static final AtomicInteger counter = new AtomicInteger();
     
    private static List<User> users;
    
	@Autowired
	private UserDAO userDao;
     
      public List<User> findAllUsers() {
        return populateDummyUsers();
    }
     
    public User findById(int id) {
    	try {
			return userDao.getUserByID(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
     
    public List<User> findByName(String name) {
        
    	try {
			return userDao.getUserByName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
     
    
    public void saveUser(User user) {
       // user.setId(counter.incrementAndGet());
        System.out.println("user to string " + user.toString());
        userDao.addUser(user);
    }
 
    public void updateUser(User user) {
    	userDao.updateUser(user);
    }
 
    public void deleteUserById(int id) {
    	userDao.deleteUser(id);
  
    }
 
    public boolean isUserExist(User user) {
      return findByName(user.getUsername())!=null;
    }
     
    public void deleteAllUsers(){
        users.clear();
    }
 
    private 
    List<User> populateDummyUsers(){
 		List<User> listUsers = null;
		try {
			listUsers = userDao.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/**        users.add(new User(counter.incrementAndGet(),"Sam", "NY", "sam@abc.com",35,434223,"415-241-2404"));
        users.add(new User(counter.incrementAndGet(),"Tomy", "ALBAMA", "tomy@abc.com",26,34324234,"415-241-2404"));
        users.add(new User(counter.incrementAndGet(),"Kelly", "NEBRASKA", "kelly@abc.com",28,23423423,"415-241-2404"));
 **/       
        return listUsers;
    }
 
   // @ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/applicationContext.xml"})
    public static void main(String[] args){
    	
        ApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");
        UserService usrImpl = (UserService) context.getBean("userService");
        User user = new User();
        user.setUsername("Adhimon");
        user.setCustomerType("Pilot");
        user.setJob("Fly");
    	usrImpl.saveUser(user);
      	System.exit(0);
    }

	
}