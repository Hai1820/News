<%@page import="com.myclass.entity.RoleEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<RoleEntity> roles = (List<RoleEntity>) request.getAttribute("roles");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm người dùng</title>
</head>
<body>
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Thêm người dùng</h4>
		</div>
	</div>
	<!-- /.row -->
	<!-- .row -->
	<div class="row">
		<div class="col-md-2 col-12"></div>
		<div class="col-md-8 col-xs-12">
			<div class="white-box">
				<form method="post"
					action="<%=request.getContextPath() + "/admin/user/add"%>"
					class="form-horizontal form-material">
					<input type="hidden" name="id" value=""
						class="form-control form-control-line">
					<div class="form-group">
						<label class="col-md-12">Họ và tên</label>
						<div class="col-md-12">
							<input value="" name="fullname" type="text" placeholder="Name"
								class="form-control form-control-line">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Tên sử dụng</label>
						<div class="col-md-12">
							<input value="" name="username" type="text"
								placeholder="Username" class="form-control form-control-line">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Password</label>
						<div class="col-md-12">
							<input value="" name="password" type="text"
								placeholder="Password" class="form-control form-control-line">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-12">Select Role</label>
						<div class="col-sm-12">
							<select name="roleid" class="form-control form-control-line">
								<%
								for (RoleEntity roleEntity : roles) {
								%>
								<option value="<%=roleEntity.getId()%>"><%=roleEntity.getName()%></option>
								<%
								}
								%>

							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<button type="submit" class="btn btn-success">Save</button>
							<a href='<c:url value = "/admin"/>' class="btn btn-primary">Back</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-2 col-12"></div>
	</div>
</body>
</html>