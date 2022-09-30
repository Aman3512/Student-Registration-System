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

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Select an option :");
		
		System.out.println("1. Add a new Course");
		System.out.println("2. Update Fee of course");
		System.out.println("3. Delete  a course ");
		System.out.println("4. Search information about a course");
		System.out.println("5. Create Batch under a course");
		System.out.println("6. Allocate students in a Batch under a course");
		System.out.println("7. Update total seats of a batch");
		System.out.println("8. View the students of every batch");
		System.out.println("9. Exit");
		
		int choice = sc.nextInt();
		
		
		switch(choice) {
		
		case 1 : System.out.println("Add a new Course");
			     Usecases.addCourse();
			     break;
			     
		case 2 : System.out.println("Update Fee of course");
		         Usecases.updateCourseFee();
		         break;
		         
		case 3 : System.out.println("Delete  a course");
		         Usecases.deleteCourse();
		         break;
		         
		case 4 : System.out.println("Search information about a course");
		         Usecases.courseDetails();
		         break;
		         
		case 5 : 
			
		}
		
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
		         
		case 2 : System.out.println("Show all courses");
			     Usecases.showAllCourse(roll);
			     break;
			
		case 3 : System.out.println("Register in a Course");
		         Usecases.registerInCourse(roll);
		         break;
		
		case 4 : System.out.println("Thank You!");
	             break;

		
		}
	}
}
