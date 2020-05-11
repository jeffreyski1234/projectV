package com.hcc.advweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentListServlet
 */
@WebServlet("/StudentListServlet")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		ArrayList<Student> stList = StudentList.getStudentList();
		
		String stID = request.getParameter("id");
		String stFName = request.getParameter("firstName");
		String stLName = request.getParameter("lastName");
		String stAddress = request.getParameter("address");
		String action = request.getParameter("a");
		if (stID != null && !stID.equals(null)) {
			
			if (action.equals("delete"))	
			{
				
				stList.remove(StudentList.getIndexById(stID));
				
				
			}
			else
			{
				Student student = new Student(Integer.parseInt(stID), stFName, stLName, stAddress);
				stList.add(student);
			}
		}
		out.flush();
		out.println("<h3> The Student List for the course is given below :</h3>");
		for (Student st:StudentList.getStudentList()) {
			out.println("<h4>"+st.getId()+", "+st.getFirstName()+" "+st.getLastName()+" " +st.getAddress() + "&nbsp;<a href=\"/examapp/StudentListServlet?id="+st.getId() + "&firstName="+st.getFirstName()+"&lastName="+st.getLastName()+"&a=delete\">Remove</a></h4>");
		}
		out.println("<h3>Add Student to the List</h3>");
		out.println("<form method=\"get\" action=\"StudentListServlet\">\r\n" + 
				"		Enter your ID, First Name and Last Name: <br/>\r\n" + 
				"		<input type=\"text\" name=\"id\" size=\"50\"><br/><br/>\r\n" + 
				"		<input type=\"text\" name=\"firstName\" size=\"50\"><br/><br/>\r\n" + 
				"		<input type=\"text\" name=\"lastName\" size=\"50\"><br/><br/>\r\n" + 
				"		<input type=\"text\" name=\"address\" size=\"50\"><br/><br/>\r\n" + 
				"		<input type=\"hidden\" name=\"a\"  value=\"add\" size=\"50\"><br/><br/>\r\n" + 
				"		<input type=\"submit\" value=\"Add Student Information\">\r\n" + 
				"	</form>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
