<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/tablib.jsp"%>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Home</a>
		</div>
		<c:if test="${not empty USER}">
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href='#'><span class="glyphicon glyphicon-user"></span>
							Welcome, ${ USER.fullName }</a></li>
					<li><a href="<c:url value ="/logout?action=logout"/>"><span
							class="glyphicon glyphicon-log-in"></span>Logout</a></li>
				</ul>
			</div>

		</c:if>
		<c:if test="${ empty USER}">
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href='#'><span class="glyphicon glyphicon-user"></span>
							Sign Up</a></li>
					<li><a href="<c:url value ="/login?action=login"/>"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</ul>
			</div>

		</c:if>

		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>
>
