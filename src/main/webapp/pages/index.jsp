<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Reports App</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h3 class="pb-3 pt-3">Reports Application</h3>
		<form:form modelAttribute="search" action="search" method="POST">
			<table>
				<tr>
					<td>Plan Name:</td>
					<td><form:select path="planName">
							<form:option value="">--select--</form:option>
							<form:options items="${names}" />
							<form:options />
						</form:select></td>


					<td>Plan status:</td>
					<td><form:select path="planStatus">
							<form:option value="">--select--</form:option>
							<form:options items="${status}" />
						</form:select></td>

					<td>Gender:</td>
					<!--  <td><form:radiobutton path="gender" value="male" />Male <form:radiobutton
							path="gender" value="Female" />Female</td>-->
					<td><form:select path="gender">
							<form:option value="">--select--</form:option>
							<form:option value="male">Male</form:option>
							<form:option value="Female">Female</form:option>

						</form:select></td>
				</tr>
				<tr>
					<td>Start Date:</td>
					<td><form:input path="startDate" type="Date" /></td>
					<td>End Date:</td>
					<td><form:input path="endDate" type="Date" /></td>

				</tr>
				<tr>
				<td><a href="/" class="btn btn-secondary" >Reset</a>
					<td><input value="Search" type="submit"
						class="btn btn-primary" /></td>
				</tr>
			</table>

		</form:form>
		<hr />

		<table class="table table-hover table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Holder Name</th>
					<th>Plan Name</th>
					<th>Plan Status</th>
					<th>Gender</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Benefit Amount</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="plan" items="${plans}" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${plan.citizenName}</td>
						<td>${plan.planName}</td>
						<td>${plan.planStatus}</td>
						<td>${plan.gender}</td>
						<td>${plan.planStartDate}</td>
						<td>${plan.planEndDate}</td>
						<td>${plan.benefitAmt}</td>
					</tr>
				</c:forEach>
				<tr>
				<c:if test="${empty plans}">
					<td colspan="8" style=" text-align:center;">No Records Found</td>
					
				</c:if>
				</tr>
			</tbody>
		</table>

		<hr />

		<td>EXPORT : <a href="excel" class="btn btn-primary">Excel</a> <a href="pdf" class="btn btn-primary">PDF</a></td>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>

</body>
</html>