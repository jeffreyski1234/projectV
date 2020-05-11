<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.IOException,java.io.PrintWriter,java.util.ArrayList,com.hcc.advweb.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration</title>
</head>
<body>
<%@ include file="header.jsp" %> 
<h1>Student Registrations</h1>
<h2></h2>
<br/>
<%



        
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
	                 sb.append("<a href=\"/examapp/register.jsp?id="+ st.getId() + "&fname="+st.getFirstName() +  "&lname="+st.getLastName()+ "&city=" + st.getCity()+ "&a=edit\">Edit</a>"); 
	                 sb.append("&nbsp;|&nbsp;");
	                 sb.append("<a href=\"/examapp/StudentOperationsServlet?id="+ st.getId() + "&fname="+st.getFirstName() +  "&lname="+st.getLastName()+ "&city=" + st.getCity()+ "&a=delete\">Remove</a></td></tr>");
	                
	             	}
	             	sb.append("</table>");
	                 out.println(sb.toString());
    		}
%>

<%@ include file="footer.jsp" %> 
</body>
</html>