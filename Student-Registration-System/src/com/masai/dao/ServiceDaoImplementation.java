package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	public Admin loginAdmin(String email, String password)throws AdminException{
		 
		Admin admin = null;
		
		try(Connection conn = DBConnection.ProvideConnection()) {
			
		  PreparedStatement ps	= conn.prepareStatement("select name from Admin where email = ? and password = ?");
			
		  ps.setString(1, email);
		  ps.setString(2, password);
		  
		  ResultSet rs = ps.executeQuery();

		  if(rs.next()) {
			  String name = rs.getString("name");
			   admin = new Admin();
			  admin.setName(name);
			 
			  
		  }else {
			  throw new AdminException("Invalid Username or Password...");
		  }
		  
		} catch (SQLException e) {
			throw new AdminException(e.getMessage());
		}
		
		return admin;
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

        Student student = null;
		
		try(Connection conn = DBConnection.ProvideConnection()) {
			
		  PreparedStatement ps	= conn.prepareStatement("select roll ,name from Student where email = ? and password = ?");
			
		  ps.setString(1, email);
		  ps.setString(2, password);
		  
		  ResultSet rs = ps.executeQuery();

		  if(rs.next()) {
			  int roll = rs.getInt("roll");
			  String name = rs.getString("name");
			  student = new Student();
			  student.setRoll(roll);
			  student.setName(name);
			 
			  
		  }else {
			  throw new StudentException("Invalid Username or Password...");
		  }
		  
		} catch (SQLException e) {
			throw new StudentException(e.getMessage());
		}
		
		return student;
	}

	

	@Override
	public String updateProfile(Student student) throws StudentException {

         String message = "not updated...";
           
         try(Connection conn = DBConnection.ProvideConnection()){
			
        	PreparedStatement  ps = conn.prepareStatement("update student set name = ? , email = ? , password = ? where roll = ?");
        	
        	ps.setString(1, student.getName());
        	ps.setString(2, student.getEmail());
        	ps.setString(3, student.getPassword());
        	ps.setInt(4, student.getRoll());
        	
        	int x = ps.executeUpdate();
        	
        	if(x>0) message = "Profile Updated successully!";
        	else throw new StudentException("Wrong Student Roll number!");
        	
        	   
		} catch (SQLException e) {
			throw new StudentException(e.getMessage());
		}
           
           return message;
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
