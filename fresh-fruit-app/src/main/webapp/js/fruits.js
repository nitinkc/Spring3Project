////////////////////////////////////////
////////////////////////////////////////
   function  pagination(){
        	  $("#previous").click(function(){
	        		  //${pageContext.request.contextPath}/fruitWithPagination.do?page=${fruitPaginationForm.currentPage - 1}
	        		  var ppage=$("#previous").attr("pageNo");
	        		  if(ppage==0){
	        			  $("#next").attr("pageNo",1);
	        			  return;
	        		  }
	        		   //  alert("ppage" +ppage);
	   	       		    //I need to make a ajax call and we are sending normal data
	   	       		    //but we need json response and we have to send pcity as an input
	   	       		     $.getJSON(ccontextPath+"/rest/fruitWithPaginationAjax.do", { page: ppage}, function(jsonResponse) {
	   	       				   var tableContent="";
				    	       var count=0;
			 			   if(!jQuery.isEmptyObject(jsonResponse)) {
			 				      var itemResponse= jsonResponse["fruitFormList"];
	    						   jQuery.each(itemResponse, function(i, item) {
	    							   //alert(item);
	    							   tableContent=tableContent+"<tr><td>"+(i+1)+"</td><td>"+item["name"]+"</td><td>"+item["price"]+"</td><td>"+item["taste"]+"</td><td>"+item["quantity"]+"</td><td>"+item["pcity"]+"</td><td> <img src=\"findImageById.do?fid="+item["sno"]+"\" height=\"40px;\" id=\"imageLoader\"></td>";
	    							   tableContent=tableContent+"<td><a href=\"editFruitByFid.do?fid="+item["sno"]+"\"><img src=\"img/edit.png\" /></a> &nbsp;&nbsp;<a href=\"javascript:deleteFruitByFid("+item["sno"]+");\"><img src=\"img/delete.png\"/></a></td></tr>";
	    						   }); 
	    						   //${fruitPaginationForm.currentPage lt fruitPaginationForm.noOfPages}
	    						    var currentPage= jsonResponse["currentPage"];
	    						    var noOfPages= jsonResponse["noOfPages"];
	    						    var recordsPerPage= jsonResponse["recordsPerPage"];
	    						    if(currentPage>1){
	    						    	$("#next").attr("pageNo",currentPage-1);
	    						    	$("#previous").attr("pageNo",currentPage-1);
	    						    }else{
	    						    	if(currentPage!=1){
	    						    		$("#next").attr("pageNo",currentPage-1);
	    						    	}
	    						     	$("#previous").attr("pageNo",currentPage-1);
	    						    	$("#previous").removeAttr("style");
	    						    	$("#previous").css({' text-decoration':'none !important', 'color':'black !important','cursor':'default'});
	    						    }
	    						    var startItem=(currentPage-1)*recordsPerPage +1;
	    						    var totalNoRecordsof = "of "+ jsonResponse["noOfRecords"];
	    						    var endRecord=0;
	    						    //
	    						    if(((currentPage-1)*recordsPerPage+recordsPerPage) >totalNoRecordsof) {
	    						    	endRecord=jsonResponse["noOfRecords"];
	    						    }else{
	    						    	endRecord=(currentPage-1)*recordsPerPage+recordsPerPage;
	    						    }
			 			            var paginationHeader = startItem+" - "+endRecord+" " +totalNoRecordsof;
	    						    $("#paginationHeader").html(paginationHeader);
	    				     		    
	    	  		   		 }else {
	    						   alert("Sorry data could not be rerieved!!!!!!!");
	    				   }
		 				  // alert(tableContent);
	   					   $("#tbodyContent").html(tableContent);
	   	       	    	});//end of getJSON
	          			
	          
	        	  }); 
	        	  
	        	  $("#next").click(function(){
	        		    //${pageContext.request.contextPath}/fruitWithPagination.do?page=${fruitPaginationForm.currentPage + 1}
	        		    /// alert("_@_@)@)@GM next");
	        		     var ppage=$("#next").attr("pageNo");
	        		  //  alert("ppage" +ppage);
	   	       		    //I need to make a ajax call and we are sending normal data
	   	       		    //but we need json response and we have to send pcity as an input
	   	       		     $.getJSON(ccontextPath+"/rest/fruitWithPaginationAjax.do", { page: ppage}, function(jsonResponse) {
	   	       				   var tableContent="";
				    	       var count=0;
			 			   if(!jQuery.isEmptyObject(jsonResponse)) {
			 				      var itemResponse= jsonResponse["fruitFormList"];
	    						   jQuery.each(itemResponse, function(i, item) {
	    							   //alert(item);
	    							   tableContent=tableContent+"<tr><td>"+(i+1)+"</td><td>"+item["name"]+"</td><td>"+item["price"]+"</td><td>"+item["taste"]+"</td><td>"+item["quantity"]+"</td><td>"+item["pcity"]+"</td><td> <img src=\"findImageById.do?fid="+item["sno"]+"\" height=\"40px;\" id=\"imageLoader\"></td>";
	    							   tableContent=tableContent+"<td><a href=\"editFruitByFid.do?fid="+item["sno"]+"\"><img src=\"img/edit.png\" /></a> &nbsp;&nbsp;<a href=\"javascript:deleteFruitByFid("+item["sno"]+");\"><img src=\"img/delete.png\"/></a></td></tr>";
	    						   }); 
	    						   //${fruitPaginationForm.currentPage lt fruitPaginationForm.noOfPages}
	    						    var currentPage= jsonResponse["currentPage"];
	    						    var noOfPages= jsonResponse["noOfPages"];
	    						    var recordsPerPage= jsonResponse["recordsPerPage"];
	    						    if(currentPage<noOfPages){
	    						    	$("#next").attr("pageNo",currentPage+1);
	    						    }else{
	    						    	//$("#next").hide();
	    						    	$("#next").removeAttr("style");
	    				            	$("#next").css({' text-decoration':'underline !important', 'color':'#075798 !important','cursor':'pointer !important'});
	    						    }
	    						    var startItem=(currentPage-1)*recordsPerPage +1;
	    						    var totalNoRecordsof = "of "+ jsonResponse["noOfRecords"];
	    						    var endRecord=0;
	    						    if((currentPage-1)*recordsPerPage+recordsPerPage >jsonResponse["noOfRecords"]) {
	    						    	endRecord=jsonResponse["noOfRecords"];
	    						    }else{
	    						    	endRecord=(currentPage-1)*recordsPerPage+recordsPerPage;
	    						    }
			 			            var paginationHeader = startItem+" - "+endRecord+" " +totalNoRecordsof;
	    						    $("#paginationHeader").html(paginationHeader);
	    				            if(currentPage!=1) {
	    				            	$("#previous").removeAttr("style");
	    				            	$("#previous").css({' text-decoration':'underline !important', 'color':'#075798 !important','cursor':'pointer !important'});
	    				            	$("#previous").attr("pageNo",currentPage-1);
	    				            }
	    				     		    
	    	  		   		 }else {
	    						   alert("Sorry data could not be rerieved!!!!!!!");
	    				   }
		 				  // alert(tableContent);
	   					   $("#tbodyContent").html(tableContent);
	   	       	    	});//end of getJSON
	        	  }); //end of click method
	        	  
	        	     //defining as a global  
	        	     //http://localhost:5050/fresh-fruit-app/
   }
   
function loadDataFromServer(jsonResponse) {
	 			  var tableContent="";
	    	       var count=0;
	 			   if(!jQuery.isEmptyObject(jsonResponse)) {
    				   jQuery.each(jsonResponse, function(i, item) {
    					   tableContent=tableContent+"<tr><td>"+(i+1)+"</td><td>"+item["name"]+"</td><td>"+item["price"]+"</td><td>"+item["taste"]+"</td><td>"+item["quantity"]+"</td><td>"+item["pcity"]+"</td><td> <img src=\"findImageById.do?fid="+item["sno"]+"\" height=\"40px;\" id=\"imageLoader\"></td>";
    					   tableContent=tableContent+"<td><a href=\"editFruitByFid.do?fid="+item["sno"]+"\"><img src=\"img/edit.png\" /></a> &nbsp;&nbsp;<a href=\"javascript:deleteFruitByFid("+item["sno"]+");\"><img src=\"img/delete.png\"/></a></td></tr>";
    				   }); 
    	  		    }else {
    					   alert("Sorry data could not be rerieved!!!!!!!");
    			   }
	 			  // alert(tableContent);
   				   $("#tbodyContent").html(tableContent);
   				    //$("#spImage").addClass("img-zoom");
   }
	   
     function deleteFruitByFid(fid) {
	        	 //  alert("_@_@_@_@)Ahah)))))))   = "+fid);
	        	   var tableContent="";
	        	    $.getJSON(ccontextPath+"/rest/fruit/"+fid, function(jsonResponse) {
	        	    	loadDataFromServer(jsonResponse);
 	    	       });//end of getJSON
	}

     function sortAscAndDescByPrice() {
    	 $("#sortPrice").click(function(){
    		   var selectedOption=$("#pcity").val();
    		   //alert("@+@+@+ = selectedOption = "+selectedOption);
				var tt=$("#sortPrice").attr("src");
				if(tt=="img/arrow_medium_up.png"){
					$("#sortPrice").attr("src","img/arrow_down_green.png");
					//sortFruit/{porder}
					$.getJSON(ccontextPath+"/rest/sortFruit/asc",{ pcity: selectedOption}, function(jsonResponse) {
			   						loadDataFromServer(jsonResponse);
					});//end of getJSON
					
				}else{
					$("#sortPrice").attr("src","img/arrow_medium_up.png");
					$.getJSON(ccontextPath+"/rest/sortFruit/desc",{pcity: selectedOption}, function(jsonResponse) {
						loadDataFromServer(jsonResponse);
					});//end of getJSON
				}
 	  });
     }

function loadDataByCity(){
	  $("#pcity").change(function() {
	    	   //accessing selected value inside drop down 
	    	   var selectedOption=$("#pcity").val();
	       		//I need to make a ajax call and we are sending normal data
	       		//but we need json response and we have to send pcity as an input
	       		$.getJSON(ccontextPath+"/rest/fruits/bycity", { pcity: selectedOption}, function(jsonResponse) {
	    			   loadDataFromServer(jsonResponse);
	       		});//end of getJSON
	       	// alert("selectedOption = "+selectedOption);
	 	});
} 
	           
	           