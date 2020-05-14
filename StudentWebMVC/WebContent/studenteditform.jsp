<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
        <h1>Edit Employee</h1>  
       <form:form method="POST" action="/StudentWebMVC/editsave">    
        <table >    
        <tr>  
        <td></td>    
         <td><form:hidden  path="id" /></td>  
         </tr>   
         <tr>    
          <td>First Name : </td>   
          <td><form:input path="Firstname"  /></td>  
         </tr>    
         <tr>    
          <td>Last Name :</td>    
          <td><form:input path="Lastname" /></td>  
         </tr>   
         <tr>    
          <td>City :</td>    
          <td><form:input path="city" /></td>  
         </tr>   
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit and Save" /></td>    
         </tr>    
        </table>    
       </form:form>    