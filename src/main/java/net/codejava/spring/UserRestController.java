package net.codejava.spring;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import net.codejava.spring.dao.UserDAO;
import net.codejava.spring.model.User;
import net.codejava.spring.service.UserService;
  
@RestController
public class UserRestController {
	
	@Autowired
	private UserDAO userDao;

	@Autowired
	   UserService userService;  //Service which will do all data retrieval/manipulation work 
    //-------------------Retrieve All Users--------------------------------------------------------
      
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity <List<User>> listAllUsers() throws Exception {
    	System.out.println("Testing testing /cagepos/user Y - 11/14");
    	//Implemeted - Usha
       List<User> users = userService.findAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
		for(int i=0; i<users.size(); i++){
			User user = (User)users.get(i);
			System.out.println(user.getUsername());
		}
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
     
    //-------------------Retrieve Single User--------------------------------------------------------
      
    @RequestMapping(value = "/user/single/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
      //Implemeted - Usha
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
  
      
      
    //-------------------find a User--------------------------------------------------------
    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUser(@PathVariable("name") String usrname) {
        System.out.println("Fetching User with name " + usrname);
      //Implemeted - Usha
        List<User> users = userService.findByName(usrname);
        if (users == null) {
            System.out.println("User with id " + usrname + " not found");
            return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getUsername());
  
        if (userService.isUserExist(user)) {
            System.out.println("A User with name " + user.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
      //Implemeted - Usha
        userService.saveUser(user);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
     
      
    //------------------- Update a User --------------------------------------------------------
      
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        System.out.println("Updating User " + id);
          
        User currentUser = userService.findById(id);
          
        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("User with id " + id + "found ");
        currentUser.setUsername(user.getUsername());
        currentUser.setEmail(user.getEmail());
        currentUser.setPhone(user.getPhone());
        //fax
        currentUser.setAddress(user.getAddress());
        currentUser.setAge(user.getAge());
        currentUser.setAccountid(user.getAccountid());        

        //Implemented - Usha
        userService.updateUser(currentUser);
        
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
  
     
    
    //------------------- Delete a User --------------------------------------------------------
   
	//Implemented
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting User with id " + id);
        //Implemented
        userService.deleteUserById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
  
      
     
    //------------------- Delete All Users --------------------------------------------------------
      
    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllUsers() {
        System.out.println("Deleting All Users");
  
        userService.deleteAllUsers();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
  

}
