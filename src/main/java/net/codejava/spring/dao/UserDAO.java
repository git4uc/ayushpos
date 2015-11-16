package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.User;

public interface UserDAO {
	public List<User> list() throws Exception;
	public void updateUser(User user);
	public void addUser(User user);	
    public void deleteUser(int id);
    public List<User> getUserByName(String name) throws Exception;
    public User getUserByID(int id) throws Exception;
}
