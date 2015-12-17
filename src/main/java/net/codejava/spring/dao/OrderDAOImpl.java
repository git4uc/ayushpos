package net.codejava.spring.dao;

 import java.util.*;

import net.codejava.spring.dao.StockDAOImpl;
import net.codejava.spring.model.Certificate;
import net.codejava.spring.model.Employee;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderDAOImpl {

	private SessionFactory sessionFactory;
    private Session session ;
	public OrderDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
 

  /* Method to add an employee record in the database */
  public Integer addEmployee(String fname, String lname, 
                                           int salary, Set cert){
     Session session = sessionFactory.openSession();
     Transaction tx = null;
     Integer employeeID = null;
     try{
        tx = session.beginTransaction();
        Employee employee = new Employee(fname, lname, salary);
        employee.setCertificates(cert);
        employeeID = (Integer) session.save(employee); 
        tx.commit();
     }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
        e.printStackTrace(); 
     }finally {
        session.close(); 
     }
     return employeeID;
  }

  /* Method to list all the employees detail */
  public void listEmployees( ){
     Session session = sessionFactory.openSession();
     Transaction tx = null;
     try{
        tx = session.beginTransaction();
        List employees = session.createQuery("FROM Employee").list(); 
        for (Iterator iterator1 = 
                          employees.iterator(); iterator1.hasNext();){
           Employee employee = (Employee) iterator1.next(); 
           System.out.print("First Name: " + employee.getFirstName()); 
           System.out.print("  Last Name: " + employee.getLastName()); 
           System.out.println("  Salary: " + employee.getSalary());
           Set certificates = employee.getCertificates();
           for (Iterator iterator2 = 
                        certificates.iterator(); iterator2.hasNext();){
                 Certificate certName = (Certificate) iterator2.next(); 
                 System.out.println("Certificate: " + certName.getName()); 
           }
        }
        tx.commit();
     }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
        e.printStackTrace(); 
     }finally {
        session.close(); 
     }
  }
  /* Method to update salary for an employee */
  public void updateEmployee(Integer EmployeeID, int salary ){
     Session session = sessionFactory.openSession();
     Transaction tx = null;
     try{
        tx = session.beginTransaction();
        Employee employee = 
                   (Employee)session.get(Employee.class, EmployeeID); 
        employee.setSalary( salary );
        session.update(employee);
        tx.commit();
     }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
        e.printStackTrace(); 
     }finally {
        session.close(); 
     }
  }
  /* Method to delete an employee from the records */
  public void deleteEmployee(Integer EmployeeID){
     Session session = sessionFactory.openSession();
     Transaction tx = null;
     try{
        tx = session.beginTransaction();
        Employee employee = 
                  (Employee)session.get(Employee.class, EmployeeID); 
        session.delete(employee); 
        tx.commit();
     }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
        e.printStackTrace(); 
     }finally {
        session.close(); 
     }
  }
}
