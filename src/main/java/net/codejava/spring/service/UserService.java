package net.codejava.spring.service;

import java.util.List;

import net.codejava.spring.model.User;
  
public interface UserService {
     
    User findById(int id);
     
    List<User> findByName(String name);
     
    void saveUser(User user);
     
    void updateUser(User user);
     
    void deleteUserById(int id);
 
    List<User> findAllUsers(); 
     
    void deleteAllUsers();
     
    public boolean isUserExist(User user);
     
}