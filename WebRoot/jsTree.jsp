<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.lang.*"%><%@page import="java.util.*"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<html>
    <head>
        <title>JSTree</title>
 <!--        <link rel="stylesheet" href="dist/themes/default/style.css" /> -->
<!--         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.js"></script>
		 <script src="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.3.7/jstree.min.js"></script>
		 <script>
		<%	javax.naming.Context ctx = new javax.naming.InitialContext();
			String restURL = (String) ctx.lookup("java:comp/env/restCommonUrl");
			
			String path="/800226326/085-49003/Production/Closing/";
			%>
            $(function() {
            	
            	 $.ajax({
        	   		 
           	   	  type : "GET",
           	   	  contentType : "application/json",
           	   		url : "<%=restURL%>/orcf/getJSTreeFolderJson?propertyId=/800226326/",
           	         dataType : 'json',
           	   	  timeout : 100000,
           	   	  success : function(data) {	 
           	   	  $('#jstree').jstree({
                      'core': {
                          'data': data.response
                      }
                  });
           	   	  },
           	   	  error : function(e) {
           	   	   console.log("ERROR: ", e);
           	   	       
           	   	  },
           	   	  done : function(e) {
           	   		            	   	  }
           	   
            	 });
             	   $('#jstree').on('click', '.jstree-anchor', function () { $('#jstree').jstree(true).toggle_node(this); })
             	   
             	   
<%--              	   var path='<%=path%>'; --%>
             	   
//              	   var model = $('#jstree').jstree(true)._model.data;
//                    var result = [];
//                    for (var i in model) {
//                      if (model.hasOwnProperty(i) && !model[i].children.length) {
//                        result.push(i);
//                      }
//                    }
//                    alert(result);
                  


            });	
				
            
                 </script>
        
        <style>
         .folderArea { 
         	width: 300px; 
         	overflow: auto; 
     float: left; 
    padding-top: 15px; 
            } 
        	#jstree {
    text-align: left;
    float: left;}
    
    #jstree ul li {
    background:  url(css/images/folder_open1.png) left top no-repeat;
        display: table-row-group;
    }
    #jstree ul {
    	list-style: none;
    	padding-left: 12px;
    }
    #jstree ul li a { padding-left: 25px; }
        </style>
    </head>
    <body>
<!--     <div class="folderArea"> -->
<!--         <div id="jstree"></div> -->
<!--         </div> -->
    </body>
</html>