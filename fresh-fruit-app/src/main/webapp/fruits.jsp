<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<title>jQuery elevateZoom Demo</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src='jquery-1.8.3.min.js'></script>
<script src='jquery.elevatezoom.js'></script>
<script src='js/fruits.js'></script>
<script type="text/javascript">
	 		   var ccontextPath="${pageContext.request.contextPath}";
	          $(document).ready(function() {
	        	  sortAscAndDescByPrice();
	        	  $('.img-zoom').hover(function() {
	        	        $(this).addClass('transition');
	        	    }, function() {
	        	    	//alert("img- remove zoom............");
	        	        $(this).removeClass('transition');
	        	    });
	        	      loadDataByCity();
	        	     //defining as a global  
	        	     //http://localhost:5050/fresh-fruit-app/
	          }); //end of ready handler....................
	</script>
<style type="text/css">

.img-zoom {
     width:60px;
	-webkit-transition: all .2s ease-in-out;
	-moz-transition: all .2s ease-in-out;
	-o-transition: all .2s ease-in-out;
	-ms-transition: all .2s ease-in-out;
}

.transition {
	-webkit-transform: scale(4);
	-moz-transform: scale(4);
	-o-transform: scale(4);
	transform: scale(4);
}
</style>
</head>
<body>
	<img src="fruit/1.jpg" id="zoom_01" />
	<br />
	<span style="margin-left: 100px;"> Filter By City : <ff:form
			commandName="fruitForm">
			<ff:select path="pcity" class="form-control"
				style="width: 20%;margin-left: 100px;">
				<ff:options items="${pcityList}" />
					<option>All</option>
			</ff:select>
		</ff:form>
	</span>

	<table class="table table-bordered"
		style="margin-left: 100px; width: 80%; background-image: url('fruit/lichi.png'); background-repeat: no-repeat; outline-color: blue; border-color: blue;">
		<thead>
			<tr>
				<th>SNo</th>
				<th>Name</th>
				<th>Price&nbsp;&nbsp;<img src="img/arrow_down_green.png" id="sortPrice"></th>
				<th>Taste</th>
				<th>Quantity</th>
				<th>City</th>
				<th>Image</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody id="tbodyContent">

			<c:forEach items="${fruitForms}" var="item" varStatus="var">
				<tr>
					<td>${var.count}</td>
					<td style="color: blue;">${item.name}</td>
					<td>${item.price}</td>
					<td>${item.taste}</td>
					<td>${item.quantity}</td>
					<td>${item.pcity}</td>
					<td><img src="findImageById.do?fid=${item.sno}"
						style="width: 40px;" class="img-zoom" id="imageLoader"></td>
					<td><a href="editFruitById.do?fid=${item.sno}"> <img
							src="img/edit.png" /></a> &nbsp;&nbsp; <a
						href="javascript:deleteFruitByFid(${item.sno});"><img
							src="img/delete.png" /></a></td>
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