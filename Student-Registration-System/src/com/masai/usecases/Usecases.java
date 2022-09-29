package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Admin;
import com.masai.bean.Student;
import com.masai.dao.ServiceDao;
import com.masai.dao.ServiceDaoImplementation;
import com.masai.exceptions.AdminException;
import com.masai.exceptions.StudentException;
import com.masai.main.SelectOptions;

public class Usecases {


	public static void registerStudent() {
		
		 Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Name :");
		String name = sc.nextLine();

		System.out.println("Enter Email :");
		String email = sc.next();
		
		System.out.println("Enter Password :");
		String password = sc.next();
		
		Student student = new Student();
		student.setName(name);
		student.setEmail(email);
		student.setPassword(password);
		
	    ServiceDao dao = new ServiceDaoImplementation();
	    String result = dao.registerStudent(student);
	    
		System.out.println(result);
		
		SelectOptions.welcomeOptions();
	}
	
	
	public static void loginAdmin() {
		
		 Scanner sc = new Scanner(System.in);
		
		 System.out.println("Enter Username/Email : ");
	     String email = sc.next();
	
	     System.out.println("Enter Password : ");
	     String password = sc.next();
	
         ServiceDao dao = new ServiceDaoImplementation();
  
	     try {
		     Admin admin =  dao.loginAdmin(email, password);
		
		     System.out.println("Welcome " + admin.getName());
		
		     SelectOptions.adminOptions();
		
	     } catch (AdminException e) {
		     e.printStackTrace();
	     }
		
	}
	
	
	
	public static void loginStudent() {
		
		 Scanner sc = new Scanner(System.in);
		
		 System.out.println("Enter Username/Email : ");
	     String email = sc.next();
	
	     System.out.println("Enter Password : ");
	     String password = sc.next();
	
         ServiceDao dao = new ServiceDaoImplementation();
  
	     try {
		     Student student =  dao.loginStudent(email, password);
		
		     System.out.println("Welcome " + student.getName());
		
		     SelectOptions.studentOptions(student.getRoll());
		
	     } catch (StudentException e) {
		     e.printStackTrace();
	     }
		
	}
	
	
	public static void updateProfile(int roll) {
		
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.println("Enter new Name :");
         String name = sc.nextLine();
         
         System.out.println("Enter new Email :");
         String email = sc.next();
         
         System.out.println("Enter new Password :");
         String password = sc.next();
         
         Student student = new Student();
         student.setRoll(roll);
 		 student.setName(name);
 		 student.setEmail(email);
 		 student.setPassword(password);
 		
 	     ServiceDao dao = new ServiceDaoImplementation();
 	     
		try {
			String result = dao.updateProfile(student);
			 System.out.println(result);
			 
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	    
 		
		SelectOptions.studentOptions(roll);
         
	}
}
