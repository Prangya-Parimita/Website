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

    <!-- Navigation -->
    <%@include file="./shared/nav.jsp"%>
  
    <!-- Home Content -->
    <c:if test="${ClickHome == true }">
		<%@include file="home.jsp"%>
	</c:if>
	
    <!-- contact us content -->
    <c:if test="${ClickContact == true }">
		<%@include file="contact.jsp"%>
	</c:if>
	
    <!-- About us content -->
    <c:if test="${ClickAbout == true }">
		<%@include file="about.jsp"%>
	</c:if>
	
    <!-- Product Content -->
    <c:if test="${userClickAllProducts == true or userClickCategoryProduct == true}">
	    <%@include file="listProduct.jsp"%>
    </c:if>
	
	 <!--Single Product Content -->
    <c:if test="${userClickSingleProduct == true}">
	    <%@include file="singleProduct.jsp"%>
    </c:if>
	
	 <!--Manage Product Content -->
    <c:if test="${userClickManageProduct == true}">
	    <%@include file="manageProduct.jsp"%>
    </c:if>
    
     <!--cart  -->
    <c:if test="${userClickShowCart == true}">
	    <%@include file="cart.jsp"%>
    </c:if>
    
	
	<!-- --footer -->
	<!-- JQuery core JavaScript -->
	     <script src="${jquery}/jquery.js"></script>
	
	<!-- JQuery Validation Plugin -->
	     <script src="${customjs}/jquery.validate.js"></script>
	
	
	<!-- Bootstrap core JavaScript -->
	     <script src="${bootjs}/bootstrap.js"></script>
	
	<!-- Bootstrap dataTable Plugin -->
		 <script src="${customjs}/jquery.dataTables.js"></script>
		
		 <script src="${customjs}/dataTables.bootstrap.js"></script>
		
		 <script src="${customjs}/bootbox.min.js"></script>
	<!-- Customs JavaScripts-->
		 <script src="${customjs}/myscript.js"></script>
		
	
	

  
</body>

</html>
