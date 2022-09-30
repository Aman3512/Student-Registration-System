package com.masai.dao;

import java.util.List;

import com.masai.bean.Admin;
import com.masai.bean.Course;
import com.masai.bean.Student;
import com.masai.bean.StudentDTO;
import com.masai.exceptions.AdminException;
import com.masai.exceptions.BatchException;
import com.masai.exceptions.CourseException;
import com.masai.exceptions.StudentException;

public interface ServiceDao {

	//  Administrator
	
	public Admin loginAdmin(String name , String password)throws AdminException;
	
	public String addCourse(Course course);
	
	public String updateFee(String cname,int fee)throws CourseException;
	
	public String deleteCourse(String cname)throws CourseException;
	
	public Course getCourseDetail(String cname)throws CourseException;
	
	public String createBatchUnderCourse(String cname)throws CourseException;
	
	public String allocateStudentInBatchUnderCourse(int roll, int batchId, String cname )throws StudentException, BatchException, CourseException;
	
	// In Batch under course table
	public String updateSeat(String cname)throws CourseException;
	
	public List<StudentDTO> getAllStudentByBatch(String cname)throws BatchException;
	
	
	// Student
	
	public String registerStudent(Student student);
	
	public Student loginStudent(String email, String password)throws StudentException;
	
	public String registerInCourse(int roll, String cname)throws StudentException ,CourseException;
	
	public String updateProfile(Student student)throws StudentException;
	
	public List<Course> showAllCourses();
	
	
	
	
}
