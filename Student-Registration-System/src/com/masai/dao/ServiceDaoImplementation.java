package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.masai.bean.Admin;
import com.masai.bean.Course;
import com.masai.bean.Student;
import com.masai.bean.StudentDTO;
import com.masai.connection.DBConnection;
import com.masai.exceptions.AdminException;
import com.masai.exceptions.BatchException;
import com.masai.exceptions.CourseException;
import com.masai.exceptions.StudentException;

public class ServiceDaoImplementation implements ServiceDao{

	@Override
	public Admin loginAdmin(String name, String password)throws AdminException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addCourse(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateFee(String cname) throws CourseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCourse(String cname) throws CourseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course getCourseDetail(String cname) throws CourseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateSeat(String cname) throws CourseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentDTO> getAllStudentByCourse(String cname) throws CourseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String registerStudent(Student student) {
		
		String message = "not inserted...";
		
		try(Connection conn = DBConnection.ProvideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into student(name,email,password) values(?,?,?)");
			
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setString(3, student.getPassword());
			
			int x = ps.executeUpdate();
			
			if(x>0) message = "Student registered Successfully!";
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		
		return message;
	}

	@Override
	public Student loginStudent(String email, String password) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public String updateProfile(int roll) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> showAllCourses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createBatchUnderCourse(String cname) throws CourseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String allocateStudentInBatchUnderCourse(int roll, int batchId, String cname)
			throws StudentException, BatchException, CourseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String registerInCourse(int roll, int cid) throws StudentException, CourseException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
