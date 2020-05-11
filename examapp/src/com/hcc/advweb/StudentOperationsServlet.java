package com.hcc.advweb;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/** * Servlet implementation class StudentOperationsServlet 
 * student operations has to branches.. register a student
 * 	and modify a student
 * 
*/
@WebServlet("/StudentOperationsServlet")
public class StudentOperationsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
   
    /**     
    * @see HttpServlet#HttpServlet()     
    */    
    public StudentOperationsServlet() {        
        super();        
        // TODO Auto-generated constructor stub    
        }
        
        /** * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) 
        */
        
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
            PrintWriter out = response.getWriter();
        
        	ArrayList<Student> stList = null;
    		
    		String stID = request.getParameter("id");
    		String stFName = request.getParameter("fname");
    		String stLName = request.getParameter("lname");
    		String stCity = request.getParameter("city");
    		String action = request.getParameter("a");
    		boolean result = false;
    		if (stID != null && !stID.equals(null)) {
    			Student s = new Student(Integer.parseInt(stID),stFName,stLName,stCity);
    				switch ( action )
    				{
    					case "delete":
    						result = StudentListDB.removeStudent(s.getId());
            		//	out.println("remove = " + result);
    						break;
    					case "add":
    						result =StudentListDB.addStudent(s);
            			//out.println("add = " + result);
    					case "edit":
    						result =StudentListDB.updateStudent(s);
            				//out.println("add = " + result);
    						break;
            			default:
            				break;
            		}
    		  response.sendRedirect("index.jsp");
    		}
    		
    		boolean isShowList = true;
    		if (isShowList )
    		{
	    		 StringBuffer sb = new StringBuffer();
	    		   out.println("<h3> Registered Students :</h3>");
	             sb.append("<table border='1'><th>St. No.</th><th>First Name </th><th>Last Name</th><th>City</th><th>Action</th></tr>");
	             
	             stList = StudentListDB.getStudentList();
	             for (Student st:stList)
	             {
	                 sb.append("<tr><td>");
	                
	                 sb.append(st.getId());
	                 sb.append("</td><td>");
	                 sb.append(st.getFirstName());
	                 sb.append("</td><td>");
	                 sb.append(st.getLastName());
	                 sb.append("</td><td>");
	  
	                 sb.append(st.getCity());
	                 sb.append("</td><td>");
	                 sb.append("<a href=\"/examapp/register.jsp?a=add\">Add</a>");
	                 sb.append("&nbsp;|&nbsp;");
	                 sb.append("<a href=\"/examapp/StudentOperationsServlet?id="+ st.getId() + "&fname="+st.getFirstName() +  "&lname="+st.getLastName()+ "&city=" + st.getCity()+ "&a=delete\">Remove</a>");
	                 sb.append("&nbsp;|&nbsp;");
	                 sb.append("<a href=\"/examapp/register.jsp?id="+ st.getId() + "&fname="+st.getFirstName() +  "&lname="+st.getLastName()+ "&city=" + st.getCity()+ "&a=edit\">Edit</a></td></tr>");   
	             	}
	             	sb.append("</table>");
	             	sb.append("<a href=\"index.jsp\">Home</a>&nbsp;|&nbsp;<a href=\"register.jsp\">Register</a> ");
	                 out.println(sb.toString());
    		}
    		
    		/*boolean isAddEdit = true;
    		if(isAddEdit)
    		{
                 out.println("<h1>Registration</h1>");
         
            out.println("<h3>Register a Student</h3>");
            out.println("<form method=\"get\" action=\"StudentOperationsServlet\">\r\n" + 
            "           Enter student's ID, First Name, Last Name, City: <br/>\r\n" + 
            "           <input type=\"text\" name=\"id\" size=\"50\"><br/><br/>\r\n" + 
            "           <input type=\"text\" name=\"fname\" size=\"50\"><br/><br/>\r\n" + 
            "           <input type=\"text\" name=\"lname\" size=\"50\"><br/><br/>\r\n" + 
            "           <input type=\"text\" name=\"city\" size=\"50\"><br/><br/>\r\n" + 
            "			<input type=\"hidden\" name=\"a\"  value=\"add\" size=\"50\"><br/><br/>\r\n" + 
            "           <input type=\"submit\" value=\"Add Student Information\">\r\n" + "     </form>");
            
    		}
    		*/
    		
        }
        
/** 
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) 
*/

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
    // TODO Auto-generated method stubdoGet(request, response);
    }
    }