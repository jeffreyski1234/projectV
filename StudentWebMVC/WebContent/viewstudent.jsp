<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Registration List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>City</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="stud" items="${list}">   
   <tr>  
   <td>${stud.id}</td>  
   <td>${stud.firstname}</td>  
   <td>${stud.lastname}</td>  
   <td>${stud.city}</td>  
   <td><a href="editstudent/${stud.id}">Edit</a></td>  
   <td><a href="deletestudent/${stud.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="studentform">Add New Employee</a>  