<%@ include file="header.jsp" %> 
<%
		boolean isAddEdit = true;
		String stID = request.getParameter("id");
		
		String stFName = request.getParameter("fname");
		String stLName = request.getParameter("lname");
		String stCity = request.getParameter("city");
		String action = request.getParameter("a");
		
		if (action == null)
		{
			action = "add";
		}
			
		
            out.println("<h1>Registration</h1>");
         
            out.println("<h3>Register a Student</h3>");
            out.println("<form method=\"get\" action=\"StudentOperationsServlet\">\r\n" + 
            "           Enter student's ID, First Name, Last Name, City: <br/>\r\n" + 
            "           <input type=\"text\" name=\"id\" value="+ stID + " size=\"50\"><br/><br/>\r\n" + 
            "           <input type=\"text\" name=\"fname\" value="+ stFName + " size=\"50\"><br/><br/>\r\n" + 
            "           <input type=\"text\" name=\"lname\" value="+ stLName + " size=\"50\"><br/><br/>\r\n" + 
            "           <input type=\"text\" name=\"city\" value="+ stCity + " size=\"50\"><br/><br/>\r\n" + 
            "			<input type=\"hidden\" name=\"a\"  value="+ action + " size=\"50\"><br/><br/>\r\n" + 
            "           <input type=\"submit\" value=\"Update Student Information\">\r\n" + "     </form>");
            
    		
    		%>
     
     
<%@ include file="footer.jsp" %> 
