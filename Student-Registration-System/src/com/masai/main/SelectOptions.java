package com.masai.main;

import java.util.Scanner;

import com.masai.bean.Admin;
import com.masai.dao.ServiceDao;
import com.masai.dao.ServiceDaoImplementation;
import com.masai.exceptions.AdminException;
import com.masai.usecases.Usecases;

public class SelectOptions {

	public static void welcomeOptions() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Select an option :");
		
		System.out.println(" 1. Login as Admin \n 2. Login as Student \n 3. New Student? Register here...");
		int choice = sc.nextInt();
		
		switch(choice) {
		
		case 1 : System.out.println("Login as Admin");
			
			System.out.println("Enter Username/Email : ");
			String email = sc.next();
			
			System.out.println("Enter Password : ");
			String password = sc.next();
			
		  ServiceDao adminCheck = new ServiceDaoImplementation();
		  
			try {
				Admin admin =  adminCheck.loginAdmin(email, password);
				
				System.out.println("Welcome " + admin.getName());
				
				SelectOptions.adminOptions();
				
			} catch (AdminException e) {
				e.printStackTrace();
			}
			
			
			break;
			
			
		case 2 :
			
			// write here
			
			break;
			
			
		case 3 :  System.out.println("New Student? Register here...");
			
		          Usecases.registerStudent();
			
			
			 break;
			 
		
			
	}
		
	}
	
	public static void adminOptions() {
		
	}
	
	public static void studentOptions() {
		
	}
}
