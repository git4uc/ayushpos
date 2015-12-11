package com.usha;



import java.util.Date;

import net.codejava.spring.dao.ItemDAO;
import net.codejava.spring.dao.StockDAOImpl;
import net.codejava.spring.service.ItemService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Test {
	
	/**@Autowired
	private  StockDAOImpl stockDoa; **/
	
	
	
	public static void main(String[] args) {
		
       ApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");
		StockDAOImpl stockDoa = (StockDAOImpl) context.getBean("stockDoa");
		         
        
        stockDoa.add();
	System.out.println("Done");
	
}
}