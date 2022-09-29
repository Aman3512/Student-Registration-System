package com.masai.main;

import java.util.Scanner;

import com.masai.usecases.Usecases;

public class SelectOptions {

	public static void welcomeOptions() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Select an option :");
		
		System.out.println(" 1. Login as Admin \n 2. Login as Student \n 3. New Student? Register here... \n 4. Exit");
		int choice = sc.nextInt();
		
		
		switch(choice) {
		
		case 1 : System.out.println("Login as Admin");
			     Usecases.loginAdmin();
			     break;
					
		case 2 : System.out.println("Login as Student");
			     Usecases.loginStudent();			
			     break;
						
		case 3 : System.out.println("New Student? Register here...");			
		         Usecases.registerStudent();			
			     break;
		
		case 4 : System.out.println("Thank You!");
			     break;
		
		
			
	}
		
	}
	
	public static void adminOptions() {

		
		// add all admin options using Switch case
		
		
	}
	
	public static void studentOptions(int roll) {

		 Scanner sc = new Scanner(System.in);
		 
		System.out.println("Select an option :");
	
		System.out.println("1. Update Profile");
		System.out.println("2. Show all courses");
		System.out.println("3. Register in a Course");
		System.out.println("4. Exit");

		int choice = sc.nextInt();
		
		switch(choice) {
		
		case 1 : System.out.println("Update Profile");
		         Usecases.updateProfile(roll);
		         break;
		         
		case 2 :
			
			
		case 3 : 
		         
		
		case 4 : System.out.println("Thank You!");
	             break;

		
		}
	}
}
