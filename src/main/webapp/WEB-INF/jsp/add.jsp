
<html>

<head>
	<%@include file="/WEB-INF/jsp/common.jsp"%>
</head>

<body>


	<div class="container">
		<div class="col-md-10 col-sm-10 col-xs-10">
			<div class="panel panel-default">
				<div class="panel-heading clearfix">
					<i class="icon-calendar"></i>
					<h3 class="panel-title">Registration form</h3>
				</div>

				<div class="panel-body">

					<form:form class="form-horizontal" method="POST"
						action="${pageContext.servletContext.contextPath}/save"
						modelAttribute="employee">

						<!--  <fieldset > -->

						<form:input type="hidden" path="id" value="${employee.id}"
							readonly="true" />

						<div class="control-group col-sm-7">
							<label class="control-label" for="username">Username</label>
							<div class="controls">
								<form:input path="name" value="${employee.name}"
									class="form-control input-sm" />
							</div>
						</div>

						<div class="control-group col-sm-7">
							<label class="control-label" for="username">Email</label>
							<div class="controls">
								<form:input path="email" value="${employee.email}"
									class="form-control input-sm" />
							</div>
						</div>

						<div class="control-group col-sm-7">
							<label class="control-label" for="username">Phone</label>
							<div class="controls">
								<form:input path="phone" value="${employee.phone}"
									class="form-control input-sm" />
							</div>
						</div>

						<div class="control-group col-sm-7">
							<label class="control-label" for="username">Location</label>
							<div class="controls">
								<form:input path="location" value="${employee.location}"
									class="form-control input-sm" />
							</div>
						</div>

						<div class="col-xs-12" style="height: 20px;"></div>

						<div class="control-group col-sm-7">

							<div class="controls">
								<button type="submit" value="Submit" name="action"
									class="btn btn-success">Submit</button>
								<button type="submit" value="Cancel" name="action"
									class="btn btn-success">Cancel</button>
							</div>

						</div>
					</form:form>

				</div>
			</div>
		</div>
	</div>


</body>
</html>