package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

		String message = "not inserted...";
		
		try(Connection conn = DBConnection.ProvideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into course(cname,fee) values(?,?)");
			
			ps.setString(1, course.getName());
			ps.setInt(2, course.getFee());
			
			int x = ps.executeUpdate();
			
			if(x>0) message = "Course Added Successfully!";
			
			
		} catch (SQLException e) {
		     message = e.getMessage();
		}
		
		
		return message;

	}

	@Override
	public String updateFee(String cname, int fee) throws CourseException {

          String message = "not updated...";
          
          try(Connection conn = DBConnection.ProvideConnection()) {
			
        	 PreparedStatement ps = conn.prepareStatement("update course set fee = ? where cname = ? ");
        	 
        	 ps.setInt(1, fee);
        	 ps.setString(2, cname);
        	 
        	 int x = ps.executeUpdate();
        	 
        	 if(x>0) message = "Fee update Successfully!";
        	 else throw new CourseException("Invalid Course name...");
        	 
		} catch (SQLException e) {
			message = e.getMessage();
		}
          
          return message;
	}

	@Override
	public String deleteCourse(String cname) throws CourseException {
 
		String message = "not deleted...";
		
		try(Connection conn = DBConnection.ProvideConnection()) {
			
		  PreparedStatement ps = conn.prepareStatement("delete from course where cname = ?");
			
		  ps.setString(1, cname);
		  
		  int x = ps.executeUpdate();
		  
		  if(x>0) message = "Course deleted Successfully!";
		  else throw new CourseException("Invalid course name");
		  
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;

	}

	@Override
	public Course getCourseDetail(String cname) throws CourseException {

		Course course = null;
		
		try(Connection conn = DBConnection.ProvideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from course where cname = ?");
			
			ps.setString(1, cname);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				course = new Course();
				
				course.setCid(rs.getInt("cid"));
				course.setName(rs.getString("cname"));
				course.setFee(rs.getInt("fee"));
				
				
			}else {
				throw new CourseException("Course doesn't exist wtih name " + cname);
			}
			
		} catch (SQLException e) {
			throw new CourseException(e.getMessage());
		}
		
		return course;

	}

	@Override
	public String updateSeat(String cname) throws CourseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentDTO> getAllStudentByBatch(String cname) throws BatchException {
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

		    List<Course> list = new ArrayList<>();
		
            try(Connection conn = DBConnection.ProvideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from course");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Course course = new Course();
				
				course.setCid(rs.getInt("cid"));
				course.setName(rs.getString("cname"));
				course.setFee(rs.getInt("fee"));
				
				list.add(course);
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;

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
	public String registerInCourse(int roll, String cname) throws StudentException, CourseException {

		String message ="Not Resgistered";
		
		
		try(Connection conn= DBConnection.ProvideConnection()) {
			
		 	PreparedStatement ps= conn.prepareStatement("select * from student where roll =?");
			
		 	
		 	ps.setInt(1, roll);
		 	
		 	ResultSet rs= ps.executeQuery();
			
		 	if(rs.next()) {
		 		
		 		PreparedStatement ps2= conn.prepareStatement("select * from course where cname=?");
		 		
		 		ps2.setString(1,cname);

		 		ResultSet rs2= ps2.executeQuery();
		 		
		 		if(rs2.next()) {
		 			
                   int cid = rs2.getInt("cid");
		 			
		 			PreparedStatement ps3= conn.prepareStatement("insert into course_student values(?,?)");
		 			
		 			
		 			ps3.setInt(1, cid);
		 			ps3.setInt(2, roll);
		 			
		 			int x= ps3.executeUpdate();
		 			
		 			if(x > 0)
		 				message = "Student registered inside the Course Sucessfully.. ";
		 			else
		 				throw new StudentException("Technical error..");
		 			
		 			
		 			
		 		}
		 		else
		 			throw new CourseException("Invalid Course...");
		 		
		 			
		 		
		 	}else
		 		throw new StudentException("Invalid Student...");
			
			
			
			
		} catch (SQLException e) {
			throw new StudentException(e.getMessage());
		}
		
		
		
		return message;
	}

	
}
