<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <header style="background-color: pink;height: 20px;">
    @Fresh Fruits Store!!!!!!!!!!!
  </header>
     
  <ff:form action="uploadFruit.do" method="post" commandName="cform" enctype="multipart/form-data">
  		 <center>	
  		  <img src="fruit/1.jpg"/>
           <table border="0" style="width: 30%;" cellspacing="10">
           		<ff:input type="hidden" path="sno"/>
           		<tr>
           			<td>Name :</td>
           			<td><ff:input type="text" path="name"  style="width: 200px;"/></td>
           		</tr>	
           		
           		<tr>
           			<td>Price :</td>
           			<td><ff:input type="text" path="price"/></td>
           		</tr>	
           		
           			<tr>
           			<td>Taste :</td>
           			<td>
           			    <ff:select path="taste">
           			    		<ff:options items="${tasteList}"/>
           			    </ff:select>
           			</td>
           		</tr>	
           		
           		<tr>
           			<td>Quantity :</td>
           			<td> 
           			   <ff:select path="quantity">
           			   		 <ff:options items="${quantityList}"/>
           			   	    </ff:select></td>
           		</tr>	
           		
           			<tr>
           			<td>Produced City :</td>
           			<td> 
           			  <ff:select path="pcity">
           			   		 <ff:options items="${pcityList}"/>
           			   	    </ff:select>    
           			    </td>
           		</tr>	
           		
           		<tr>
           			<td>Upload Image :</td>
           			<td> 
           			     <input type="file"  name="image">
           			    </td>
           		</tr>	
           		
           			<tr>
           			<td>&nbsp; </td>
           			<td> 
           			  <input type="submit" value="Upload" style="background-color: pink"/>
           			</td>
           		</tr>	
           
           </table>
           </center>
          
  </ff:form>
  <br/><br/><br/><br/><br/>
     <footer style="background-color:cyan;height: 20px;">
    @fruit@gmail.com
  </footer>
</body>
</html>