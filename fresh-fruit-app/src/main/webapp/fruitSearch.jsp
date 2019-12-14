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
  
  <form action="fruitDetail.do" method="post">
           <h3>Enter the fruit</h3>  <input type="text" name="fname"/>
            <input type="submit" value="Detail." style="background-color: pink"/>
  </form>
   <br/>
     Fruit Detail............
     <br/>
         <h2>${result}</h2>
         <br/>
      <img src="${pppppfruitName}"/>
   
</body>
</html>