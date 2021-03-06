<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/tablib.jsp"%>

<!DOCTYPE html>
<html>
<head>

<title><dec:title default="Admin" /></title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">



<!-- Custom fonts for this template-->
<link
	href="<c:url value ='/template/admin/vendor/fontawesome-free/css/all.min.css'/>"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="<c:url value ='/template/admin/css/sb-admin-2.min.css'/>"
	rel="stylesheet">
<!-- Custom link pagination for this template-->



</head>
<body id="page-top">
	<div id="wrapper">
		<%@include file="/common/admin/menu.jsp"%>
		<div id="content-wrapper" class="d-flex flex-column">

			<div id="content">
				<%@include file="/common/admin/header.jsp"%>
				<dec:body />
			</div>
			<%@include file="/common/admin/footer.jsp"%>
		</div>
	</div>


	<!-- Bootstrap core JavaScript-->
	<script
		src="<c:url value ='/template/admin/vendor/jquery/jquery.min.js'/>"></script>
	<script
		src="<c:url value ='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

	<script
		src="<c:url value ='/template/admin/vendor/jquery-easing/jquery.easing.min.js'/>"></script>

</body>
</html>