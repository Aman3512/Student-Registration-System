package com.masai.main;

import java.util.Scanner;

import com.masai.usecases.Usecases;

public class SelectOptions {

	
	public static void welcomeOptions() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nSelect an option :");
		System.out.println("******************\n");
		
		System.out.println(" 1. Login as Admin \n 2. Login as Student \n 3. New Student? Register here... \n 4. Exit");
		int choice = sc.nextInt();
		
		
		switch(choice) {
		
		case 1 : System.out.println("\n**Login as Admin**\n");
			     Usecases.loginAdmin();
			     break;
					
		case 2 : System.out.println("\n**Login as Student**\n");
			     Usecases.loginStudent();			
			     break;
						
		case 3 : System.out.println("\n**New Student? Register here...**\n");			
		         Usecases.registerStudent();			
			     break;
		
		case 4 : System.out.println("\n**Thank You**\n");
			     break;
			
	}
		
	}
	
	
	public static void adminOptions() {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nSelect an option :");
		System.out.println("******************\n");
		
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
		
		case 1 : System.out.println("\n**Add a new Course**\n");
			     Usecases.addCourse();
			     break;
			     
		case 2 : System.out.println("\n**Update Fee of course**\n");
		         Usecases.updateCourseFee();
		         break;
		         
		case 3 : System.out.println("\n**Delete  a course**\n");
		         Usecases.deleteCourse();
		         break;
		         
		case 4 : System.out.println("\n**Search information about a course**\n");
		         Usecases.courseDetails();
		         break;
		         
		case 5 : System.out.println("\n**Create Batch under a course**\n");
		         Usecases.batchUnderCourse();
		         break;
		      
		case 6 : System.out.println("\n**Allocate students in a Batch under a course**\n");
		         Usecases.allocatedStudentInBatch();
		         break;
		         
		case 7 : System.out.println("\n**Update total seats of a batch**\n");
		         Usecases.updateSeat();
		         break;
		         
		case 8 : System.out.println("\n**View the students of every batch**\n");
		         Usecases.viewStudentofBatch();
		         break;
		         
		case 9 : System.out.println("\n**Thank You**\n");
		         break;
			
		}
		
	}
	
	
	public static void studentOptions(int roll) {

		 Scanner sc = new Scanner(System.in);
		 
		System.out.println("\nSelect an option :");
		System.out.println("******************\n");
		
		System.out.println("1. Update Profile");
		System.out.println("2. Show all courses");
		System.out.println("3. Register in a Course");
		System.out.println("4. Exit");

		int choice = sc.nextInt();
		
		switch(choice) {
		
		case 1 : System.out.println("\n**Update Profile**\n");
		         Usecases.updateProfile(roll);
		         break;
		         
		case 2 : System.out.println("\n**Show all courses**\n");
			     Usecases.showAllCourse(roll);
			     break;
			
		case 3 : System.out.println("\n**Register in a Course**\n");
		         Usecases.registerInCourse(roll);
		         break;
		
		case 4 : System.out.println("\n**Thank You**\n");
	             break;
		
		}
		
	}
}
