<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
     
    <spring:url var="customcs" value="/rs/css" />
    <spring:url var="custumjs" value="/rs/js" />
    <spring:url var="jquery" value="/rs/vendor/jquery " />
    <spring:url var="bootcs" value="/rs/vendor/bootstrap/css" />
    <spring:url var="bootjs" value="/rs/vendor/bootstrap/js" />


     <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
    
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="Online website">
  <meta name="author" content="ruchi">

  <title>Online Shopping ${title}</title>

  <!-- Bootstrap core CSS -->
  <link href="${bootcs}/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="${customcs}/shop-homepage.css" rel="stylesheet">

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
	
   <!-- Services Content -->
	<c:if test="${ClickServices == true }">
		<%@include file="services.jsp"%>
	</c:if>
	
	<!-- Footer -->
	<%@include file="./shared/footer.jsp"%>
	
	
  <!-- Bootstrap core JavaScript -->
  <script src="${jquery }/jquery.min.js"></script>
  <script src="${bootjs }/bootstrap.bundle.min.js"></script>
  <script src="${customjs }/myscript.js"></script>

</body>

</html>
