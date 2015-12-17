package com.usha;

 import java.util.*;

import net.codejava.spring.dao.OrderDAOImpl;

import net.codejava.spring.model.Certificate;
import net.codejava.spring.model.Employee;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrder {
 
	
  public static void main(String[] args) {
	     ApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");


     /* Let us have a set of certificates for the first employee  */
     HashSet set1 = new HashSet();
     set1.add(new Certificate("MCA"));
     set1.add(new Certificate("MBA"));
     set1.add(new Certificate("PMP"));
    
     /* Add employee records in the database */
		OrderDAOImpl orderDoa = (OrderDAOImpl) context.getBean("orderDoa");

     Integer empID1 = orderDoa.addEmployee("Manoj", "Kumar", 4000, set1);

     /* Another set of certificates for the second employee  */
     HashSet set2 = new HashSet();
     set2.add(new Certificate("BCA"));
     set2.add(new Certificate("BA"));

     /* Add another employee record in the database */
     Integer empID2 = orderDoa.addEmployee("Dilip", "Kumar", 3000, set2);

     /* List down all the employees */
     orderDoa.listEmployees();

     /* Update employee's salary records */
     orderDoa.updateEmployee(empID1, 5000);

     /* Delete an employee from the database */
     orderDoa.deleteEmployee(empID2);

     /* List down all the employees */
     orderDoa.listEmployees();

  }

 
}
