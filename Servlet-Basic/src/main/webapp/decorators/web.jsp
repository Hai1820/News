<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/tablib.jsp"%>
<!DOCTYPE html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title><dec:title default="Home" /></title>


<link href="<c:url value ='/template/web/css/bootstrap.min.css'/>"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value ='/template/web/css/shop-homepage.css'/>"
	rel="stylesheet">


</head>
<body>
	<%@include file="/common/web/header.jsp"%>

	<div class="container"></div>
	

	<div class="container">
		<dec:body />
	</div>
	<%@include file="/common/web/footer.jsp"%>
	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value='template/web/js/jquery.js'/>"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value='template/web/js/bootstrap.min.js'/>"></script>
</body>