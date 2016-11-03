
package com.usha;

import java.util.*;

import net.codejava.spring.dao.ItemDAOImpl;
import net.codejava.spring.dao.OrderDAOImpl;

import net.codejava.spring.model.Certificate;
import net.codejava.spring.model.Employee;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestItem {

	
 public static void main(String[] args) {
	     ApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");


   
    /* Add employee records in the database */
		ItemDAOImpl itemDoa = (ItemDAOImpl) context.getBean("itemDao");

		  /**Session session = sessionFactory.openSession (); 
		  Transaction tx = session.beginTransaction (); 
		  String hqlUpdate = "update Customer set name =: newName where name =: oldName"; 
		  int updatedEntities = s.createQuery (hqlUpdate). SetString ("newName ", newName). setString (" oldName ", oldName). executeUpdate (); 
		  tx.commit (); 
		  session.close (); **/

    /* List down all the employees */
    try {
		itemDoa.list();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}



 }


}
