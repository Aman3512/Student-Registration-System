package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.bean.Admin;
import com.masai.bean.Course;
import com.masai.bean.Student;
import com.masai.dao.ServiceDao;
import com.masai.dao.ServiceDaoImplementation;
import com.masai.exceptions.AdminException;
import com.masai.exceptions.CourseException;
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
	
	
	public static void addCourse() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Course Name : ");
		String name = sc.nextLine();
		
		System.out.println("Enter Course Fee :");
		int fee = sc.nextInt();
		
		Course course = new Course();
		course.setName(name);
		course.setFee(fee);
		
		ServiceDao dao = new ServiceDaoImplementation();
		
		String result = dao.addCourse(course);
		System.out.println(result);
		
		SelectOptions.adminOptions();
		
	}
	
	
	public static void updateCourseFee() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Course name :");
		String name = sc.nextLine();
		
		System.out.println("Enter New fee :");
		int fee = sc.nextInt();
		
		ServiceDao dao = new ServiceDaoImplementation();
		
		try {
			String result = dao.updateFee(name, fee);
			System.out.println(result);
			
		} catch (CourseException e) {
			e.printStackTrace();
		}
		
		SelectOptions.adminOptions();
	}
	
	
	public static void deleteCourse() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Course Name :");
		String name = sc.nextLine();
		
		ServiceDao dao = new ServiceDaoImplementation();
		
		try {
			String result = dao.deleteCourse(name);
			System.out.println(result);
			
		} catch (CourseException e) {
			e.printStackTrace();
		}
		
		
		SelectOptions.adminOptions();
	}
	
	
	public static void courseDetails() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter course name :");
        String name = sc.nextLine();	
        
        ServiceDao dao = new ServiceDaoImplementation();
        
        try {
			Course course = dao.getCourseDetail(name);
			
			System.out.println("------------------------------------");
			System.out.println("Course Id : " + course.getCid());
			System.out.println("Course Name : " + course.getName());
			System.out.println("Courses Fee : " + course.getFee());
			System.out.println("-------------------------------------");
			
		} catch (CourseException e) {
			e.printStackTrace();
		}
        
        SelectOptions.adminOptions();
	}
	
	
	public static void showAllCourse(int roll) {
		
        ServiceDao dao = new ServiceDaoImplementation();
        
        try {
			List<Course> list = dao.showAllCourses();
			
		    list.forEach(course ->{
		    	
		    	System.out.println("------------------------------------");
				System.out.println("Course Id : " + course.getCid());
				System.out.println("Course Name : " + course.getName());
				System.out.println("Courses Fee : " + course.getFee());
				System.out.println("-------------------------------------");
		    	
		    });
		 	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        SelectOptions.studentOptions(roll);
		
	}
	
	public static void registerInCourse(int roll) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Course Name :");
		String cname = sc.nextLine();
		
		 ServiceDao dao = new ServiceDaoImplementation();
		 
		 try {
			String result = dao.registerInCourse(roll, cname);
			System.out.println(result);
			
		} catch (StudentException | CourseException e) {
			
			e.printStackTrace();
		}
		 
		 SelectOptions.studentOptions(roll);
		
	}
}
