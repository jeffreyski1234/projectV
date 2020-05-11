package com.hcc.advweb;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentListDB {
	
	private static ArrayList<Student> studentList = new ArrayList<Student>();

	public static ArrayList<Student> getStudentList() {
		 Connection conn = null;
         Statement stmt = null;
         ResultSet rs = null;
         studentList.clear();
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             String connURL = "jdbc:mysql://localhost:3306/studentdb?characterEncoding=utf8&serverTimezone=UTC";
             String user = "root";
             String pwd = "Admin123";
             conn = DriverManager.getConnection(connURL, user, pwd);
              stmt = conn.createStatement();
              rs = stmt.executeQuery("Select * from STUDENT;");
             
  			
              while (rs.next())            
              {
    			studentList.add(new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(5)));
    			
              }
         	}
             catch(SQLException | ClassNotFoundException e) 
             {
                 System.out.println("GetStudentList !! SOME THING BAD HAPPENED !");

             }
             finally {
                 try {
                 	rs.close();
                 	stmt.close();
                 	conn.close();
                 	} catch (SQLException e) 
                 {}
                 }
		return studentList;
	}
	public static void setStudentsList(ArrayList<Student> studentList) {
		StudentListDB.studentList = studentList;
	}

	public static boolean addStudent(Student student) {
		 Connection conn = null;
         Statement stmt = null;
         ResultSet rs = null;
         boolean result = false;
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             String connURL = "jdbc:mysql://localhost:3306/studentdb?characterEncoding=utf8&serverTimezone=UTC";
             String user = "root";
             String pwd = "Admin123";
             conn = DriverManager.getConnection(connURL, user, pwd);
             String sql = "INSERT INTO STUDENT (ID,FNAME,LNAME, CITY) VALUES (?,?,?,?)";
             PreparedStatement st = conn.prepareStatement(sql);
             st.setInt(1, student.getId());
             st.setString(2, student.getFirstName());
             st.setString(3, student.getLastName());
             st.setString(4, student.getCity());
             st.execute();
             
              if (studentList != null && !studentList.equals(null))
              {
            	  studentList.clear();
              }
              studentList = getStudentList();
              

             }
             catch(SQLException | ClassNotFoundException e) 
             {
                 System.out.println("AddStudent !! SOME THING BAD HAPPENED !");

             }
             finally {
                 try {
                 	
                	 if (rs != null && !rs.equals(null))
                	 {
                		 rs.close();
                		 stmt.close();
                		 conn.close();
                	 }
                 	} catch (SQLException e) 
                 {}
                 }
          result = true;
		return result;
	}
	
	public static boolean updateStudent(Student student) {
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connURL = "jdbc:mysql://localhost:3306/studentdb?characterEncoding=utf8&serverTimezone=UTC";
            String user = "root";
            String pwd = "Admin123";
            conn = DriverManager.getConnection(connURL, user, pwd);
            String sql = "UPDATE STUDENT SET FNAME = ?, LNAME= ?, CITY = ? WHERE id=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(4, student.getId());
            st.setString(1, student.getFirstName());
            st.setString(2, student.getLastName());
            st.setString(3, student.getCity());
            st.execute();
            
             if (studentList != null && !studentList.equals(null))
             {
           	  studentList.clear();
             }
             studentList = getStudentList();
             

            }
            catch(SQLException | ClassNotFoundException e) 
            {
                System.out.println("UpdateStudent !! SOME THING BAD HAPPENED !");

            }
            finally {
                try {
                	
               	 if (rs != null && !rs.equals(null))
               	 {
               		 rs.close();
               		 stmt.close();
               		 conn.close();
               	 }
                	} catch (SQLException e) 
                {}
                }
         result = true;
		return result;
	}
	
	public static boolean removeStudent(int id) {
		  Connection conn = null;
          Statement stmt = null;
          ResultSet rs = null;
          boolean result = false;
          try {
              Class.forName("com.mysql.cj.jdbc.Driver");
              String connURL = "jdbc:mysql://localhost:3306/studentdb?characterEncoding=utf8&serverTimezone=UTC";
              String user = "root";
              String pwd = "Admin123";
              conn = DriverManager.getConnection(connURL, user, pwd);
              String sql = "DELETE FROM STUDENT WHERE ID = " + id;
              PreparedStatement st = conn.prepareStatement(sql);

              st.execute();
               stmt = conn.createStatement();
               if (studentList != null && !studentList.equals(null))
               {
             	  studentList.clear();
               }
               studentList = getStudentList();
               ;

              }
              catch(SQLException | ClassNotFoundException e) 
              {
                  System.out.println("removeStudent !! SOME THING BAD HAPPENED !");

              }
              finally {
                  try {
                	  if (rs != null && !rs.equals(null))
                 	 {
                 		 rs.close();
                 		 stmt.close();
                 		 conn.close();
                 	 }
                  	} catch (SQLException e) 
                  {}
                  }
          
          result = true;
		return result;
		
	}
	
	public static int getIndexById(String stID) {
		int ind = -1;
		for(int i=0;i<studentList.size();i++)
		{
			Student s = studentList.get(i);
			if( Integer.toString(s.getId()).equals(stID))
			{
				return i;
			}
		}
		return ind;
	}

	public StudentListDB() {
		// TODO Auto-generated constructor stub
	}}
