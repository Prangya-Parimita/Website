<br/>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <h1 class="my-4">Categories</h1>
 <div class="list-group">
 <c:forEach items="${categories}" var="category">
 
 	<a href="${contextRoot}/show/category/${category.id}/product" class="list-group-item">${category.name} </a>
 </c:forEach>
          
          
 </div>

