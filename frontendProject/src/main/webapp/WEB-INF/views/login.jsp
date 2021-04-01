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

   <title>Online Shopping - ${title}</title>
   
   <script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
   </script>

   <!-- Bootstrap core CSS -->
   <link href="${bootcss}/bootstrap.min.css" rel="stylesheet">
    
      
    <!-- Custom theme for this template -->
   <link href="${customcss}/bootstrap.yeti.theme.css" rel="stylesheet">
  
   <!-- Bootstrap DataTable -->
   <link href="${customcss}/dataTables.bootstrap.css" rel="stylesheet">
   
      <!-- Custom styles for this template -->
   <link href="${customcss}/shop-homepage.css" rel="stylesheet">
</head>

<body>
	<div class="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">Online
						Shopping</a>
				</div>
			</div>
		</nav>
       
		<div class="content">
            <div class ="container">
              <c:if test="${not empty message}">
               <div class="row">
                 <div class="col-md-offset-3 col-md-6">
                      <div class="alert alert-success fade in">${message}</div>
                  </div>
				</div>
			  </c:if>
			  
			  <c:if test="${not empty logout}">
               <div class="row">
                 <div class="col-md-offset-3 col-md-6">
                      <div class="alert alert-danger fade in">${logout}</div>
                  </div>
				</div>
			   </c:if>
			   
                   <div class="row">
                   <div class="col-md-offset-3 col-md-6">
                    <div class="card card-primary">
                    <div class="card-heading"> 
					<h4>Login</h4>
							</div>

							<div class="card-body">
								<form action="${contextRoot}/login"
								      method="POST"
								      class="form-horizontal"
								      id="loginForm">

									<div class="form-group">
										<label for="username" class="col-md-4 control-label">Email:
										</label>
										<div class="col-md-8">
											<input type="text" name="username" id="username"
												   class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label for="password" class="col-md-4 control-label">Password:
										</label>
										<div class="col-md-8">
											<input type="password" name="password" id="password"
												   class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-offset-4 col-md-8"> 
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
											<input type="submit" value="Login" class="btn btn-primary" />
										</div>
									</div>
									<div class="card-footer">
								         <div class="text-right">
									          New User - <a href="${contextRoot}/register">Register Here</a>
								         </div>
							        </div>
									
								</form>

							</div>
							
						</div>

					</div>

				</div>

			</div>

</div>

	</div>	
	
	
	<!-- JQuery core JavaScript -->
	<script src="${jquery}/jquery.min.js"></script>
	
	<!-- JQuery Validation Plugin -->
	<script src="${customjs}/jquery.validate.js"></script>

     <script src="${customjs}/bootbox.min.js"></script>
	<!-- Customs JavaScripts-->
		<script src="${customjs}/myscript.js"></script>
		
	
	

  
</body>

</html>
