package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Student;
import com.masai.dao.ServiceDao;
import com.masai.dao.ServiceDaoImplementation;

public class Usecases {

	static Scanner sc = new Scanner(System.in);
	
	public static void registerStudent() {
		
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
	}
}
