<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset='utf-8'/>
	<title>jQuery elevateZoom Demo</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src='jquery-1.8.3.min.js'></script>
	<script src='jquery.elevatezoom.js'></script>
</head>
<body>
<h1>Basic Zoom Example</h1>
 <img id="zoom_01" src='images/small/image1.png' data-zoom-image="images/large/image1.jpg"/> 
  <img src="fruit/1.jpg" id="zoom_01"/>
<br />

 <table class="table table-bordered" style="width: 80%;background-image: url('fruit/lichi.png');background-repeat: no-repeat;outline-color: blue;border-color: blue;">
        <thead>
            <tr>
                <th>SNo</th>
                <th>Name</th>
                <th>Price</th>
                <th>Taste</th>
                <th>Quantity</th>
                <th>City</th>
                <th>Image</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        
          <c:forEach items="${fruitForms}" var="item" varStatus="var">
            <tr>
                <td>${var.count}</td>
                <td style="color:blue;">${item.name}</td>
                <td>${item.price}</td>
                <td>${item.taste}</td>
                <td>${item.quantity}</td>
                <td>${item.pcity}</td>
                <td>
               			 <img src="findImageById.do?fid=${item.sno}" style="width: 40px;" class="img-circle">
                
                </td>
                <td>
                <a href="editFruitById.do?fid=${item.sno}"> 
                <img src="img/edit.png" /></a> &nbsp;&nbsp;
                
                 <a href="deleteFruitById.do?fid=${item.sno}"><img src="img/delete.png" /></a></td>
            </tr>
          </c:forEach>
            
            
        </tbody>
    </table>

<script>
    $('#zoom_01').elevateZoom({
    zoomType: "inner",
cursor: "crosshair",
zoomWindowFadeIn: 500,
zoomWindowFadeOut: 750
   }); 
</script>
</body>
</html>