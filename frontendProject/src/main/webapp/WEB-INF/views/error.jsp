<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
     
    <spring:url var="customcss" value="/rs/css" />
    <spring:url var="customjs" value="/rs/js" />
    <spring:url var="jquery" value="/rs/vendor/jquery" />
    <spring:url var="bootcss" value="/rs/vendor/bootstrap/css" />
    <spring:url var="bootjs" value="/rs/vendor/bootstrap/js" />
    <spring:url var="images" value="/rs/images" />

     <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
    
<!DOCTYPE html>
<html lang="en">

<head>

   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <meta name="description" content="Online Shopping site">
  <meta name="author" content="ruchi">

   <title>EZ Shopping - ${title}</title>
   
   <script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
   </script>

   <!-- Bootstrap core CSS -->
   <link href="${bootcss}/bootstrap.min.css" rel="stylesheet">
    
      
    <!-- Custom theme for this template -->
   <link href="${customcss}/bootstrap.united.theme.css" rel="stylesheet">
  
   <!-- Bootstrap DataTable -->
   <link href="${customcss}/dataTables.bootstrap.css" rel="stylesheet">
   
      <!-- Custom styles for this template -->
   <link href="${customcss}/shop-homepage.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">

	    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	        <div class="container">
	            <!-- Brand and toggle get grouped for better mobile display -->
	            <div class="navbar-header">
	                <a class="navbar-brand" href="${contextRoot}/home">Home</a>
	            </div>
			</div>
		</nav>
			
		
		<div class="content">
		
			<div class="container">
			
				<div class="row">
				
					<div class="col-xs-12">
					
						
						<div class="jumbotron">
						
							<h1>${errorTitle}</h1>
							<hr/>
						
							<blockquote style="word-wrap:break-word">
								
								${errorDescription}
							
							</blockquote>						
						
						</div>
						
											
					</div>					
				
				</div>
			
			</div>
							
		</div>

	</div>
		
	
</body>


</html>