package com.ems.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ems.model.Employee1;



public class EmployeeDAO {

	Configuration cfg;
	SessionFactory sFac;
	public EmployeeDAO(){

		cfg=new Configuration();
        
        sFac=cfg.addAnnotatedClass(Employee1.class).configure().buildSessionFactory();
       
	}
	public void newEmployee(Employee1 e) {
		Session s=sFac.openSession();
        Transaction tx=s.beginTransaction();
        s.save(e);
        tx.commit();
        s.close();
        System.out.println("Employee Added!");
	}
	
	public void getEmployee(int empno){
		Session s=sFac.openSession();
        Transaction tx=s.beginTransaction();
        
        Employee1 e=null;
        e=s.get(Employee1.class, empno);
        System.out.println(e);
        
        tx.commit();
        s.close();
		
		
	}
	
	public List<Employee1> getAllEmployees(){
		Session s=sFac.openSession();
        Transaction tx=s.beginTransaction();
        
        List<Employee1> ls=new ArrayList<>();
        ls=s.createQuery("from Employee1").list();
        
        tx.commit();
        s.close();
		return ls;
		
	}
	
	 public void updateEmployee(int empno) {
		 Scanner sc=new Scanner(System.in);
		 Session s=sFac.openSession();
	        Transaction tx=s.beginTransaction();
	        

	        Employee1 e=null;
	        e=s.get(Employee1.class, empno);
	        if(e==null) {
	        	System.out.println("Invalid username");
	        	return;
	        }
	        System.out.println(e);
	        
	        System.out.println("Enter new name:");
	        e.setName(sc.next());
	        System.out.println("Enter new age:");
	        e.setAge(sc.nextInt());
	        System.out.println("Enter new city:");
	        e.setCity(sc.next());
	        
	        s.update(e);
	        tx.commit();
	        s.close();
	        System.out.println("Updation done!");
	 }
	 
	 public void deleteEmployee(int empno) {
		 Session s=sFac.openSession();
	        Transaction tx=s.beginTransaction();
	        
	        Employee1 e=null;
	        e=s.get(Employee1.class, empno);
	        if(e==null) {
	        	System.out.println("Invalid id");
	        	return;
	        }
	        s.delete(e);
	        
	        tx.commit();
	        s.close();
	        System.out.println("Deleted successfully!");
	 }
}
