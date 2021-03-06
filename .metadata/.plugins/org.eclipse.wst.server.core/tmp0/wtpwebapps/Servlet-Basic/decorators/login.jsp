<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/tablib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<!--===============================================================================================-->
<link rel="icon" type="image/png"
	href="<c:url value = "/template/login/images/icons/favicon.ico" /> " />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/template/login/vendor/bootstrap/css/bootstrap.min.css" /> ">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/template/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css" /> ">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/template/login/vendor/animate/animate.css" /> ">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/template/login/vendor/css-hamburgers/hamburgers.min.css" /> ">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/template/login/vendor/select2/select2.min.css" /> ">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/template/login/css/util.css" /> ">
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/template/login/css/main.css" /> ">
<!--===============================================================================================-->


</head>
<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="<c:url value = "/template/login/images/img-01.png" />"
						alt="IMG">
				</div>

				<form class="login100-form validate-form" method="post"
					action="<%=request.getContextPath() + "/login"%>">
					<span class="login100-form-title"> Member Login </span>
					<c:if test="${not empty message }">
						<div class="alert alert-${alert}">
							<strong>${message}</strong>
						</div>
					</c:if>

					<div class="wrap-input100 validate-input">
						<input class="input100" type="text" name="username"
							placeholder="Username"> <span class="focus-input100"></span>
						<span class="symbol-input100"> <i class="fa fa-envelope"
							aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Password is required">
						<input class="input100" type="password" name="password"
							placeholder="Password"> <span class="focus-input100"></span>
						<span class="symbol-input100"> <i class="fa fa-lock"
							aria-hidden="true"></i>
						</span>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn" type="submit">Login</button>
					</div>

					<div class="text-center p-t-12">
						<span class="txt1"> Forgot </span> <a class="txt2" href="#">
							Username / Password? </a>
					</div>

					<div class="text-center p-t-136">
						<a class="txt2" href="#"> Create your Account <i
							class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
						</a>
					</div>
					<input type="hidden" value="login" id="action" name="action" />
				</form>
			</div>
		</div>
	</div>

	<!--===============================================================================================-->
	<script
		src="<c:url value = "/template/login/vendor/jquery/jquery-3.2.1.min.js" /> "></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value = "/template/login/vendor/bootstrap/js/popper.js" /> "></script>
	<script
		src="<c:url value = "/template/login/vendor/bootstrap/js/bootstrap.min.js" /> "></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value = "/template/login/vendor/select2/select2.min.js" /> "></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value = "/template/login/vendor/tilt/tilt.jquery.min.js" /> "></script>
	<script>
		$('.js-tilt').tilt({
			scale : 1.1
		})
	</script>
	<!--===============================================================================================-->
	<script src="<c:url value = "/template/login/js/main.js" /> "></script>
</body>
</html>