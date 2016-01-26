
<html>

<head>
	<%@include file="/WEB-INF/jsp/common.jsp"%>
</head>

<body>
<br><br>

<div class="container">
	
	<div class="text-right">
		<a href="${pageContext.servletContext.contextPath}/add">Click here to add new user</a>
	</div>
	<br>
	<h4>List of employees</h4>

	<table class="table table-bordered table-hover">
	  <thead class="thead">
	    <tr>
	      <th>#</th>
	      <th>Name</th>
	      <th>eMail</th>
	      <th>Phone</th>
	      <th>Location</th>
	      <th>Edit</th>
		  <th>Delete</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:if test="${!empty employees}">
	  
	  	<c:forEach items="${employees}" var="employee" varStatus="loop">
	  		<tr>
	      	  <th scope="row">${loop.index+1}</th>
		      <td>${employee.name}</td>
		      <td>${employee.email}</td>
		      <td>${employee.phone}</td>
		      <td>${employee.location}</td>
		      <td><a href="${pageContext.servletContext.contextPath}/edit/${employee.id}">Edit</a> </td>
			  <td><a href="${pageContext.servletContext.contextPath}/delete/${employee.id}">Delete</a></td>
	    </tr>
	  	</c:forEach>
	  </c:if>
	  <c:if test="${empty employees}">
		  <tr>
		  	<td colspan="7" class="text-center"> No data is available!</td>
		  </tr>
	 </c:if>
	  </tbody>
	</table>
</div>
</body>
</html>