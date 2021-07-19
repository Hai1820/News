
<%@page import="com.myclass.entity.RoleEntity"%>
<%@page import="com.myclass.entity.UserEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<RoleEntity> roles = (List<RoleEntity>) request.getAttribute("roles");
UserEntity user = (UserEntity) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa thông tin người dùng</title>

</head>
<body>
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Chỉnh sửa thông tin</h4>
		</div>
	</div>
	<!-- /.row -->
	<!-- .row -->
	<div class="row">
		<div class="col-md-2 col-12"></div>
		<div class="col-md-8 col-xs-12">
			<div class="white-box">
				<form method="post"
					action="<%=request.getContextPath() + "/admin/user/edit"%>"
					class="form-horizontal form-material">
					<input type="hidden" name="id" value="<%=user.getId()%>"
						class="form-control form-control-line">
					<div class="form-group">
						<label class="col-md-12">Họ và Tên</label>
						<div class="col-md-12">
							<input value="<%=user.getFullName()%>" name="fullname"
								type="text" placeholder="FullName"
								class="form-control form-control-line">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Tên sử dụng</label>
						<div class="col-md-12">
							<input value="<%=user.getUserName()%>" name="username"
								type="text" placeholder="Username"
								class="form-control form-control-line">
						</div>
					</div>



					<div class="form-group">
						<label class="col-sm-12">Select Category</label>
						<div class="col-sm-12">
							<select name="roleid" class="form-control form-control-line">
								<%
								for (RoleEntity roleEntity : roles) {
									String selected = user.getRoleId() == roleEntity.getId() ? "selected" : "";
								%>
								<option value="<%=roleEntity.getId()%>" <%=selected%>><%=roleEntity.getName()%></option>
								<%
								}
								%>

							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<button type="submit" class="btn btn-success">Update
								News</button>
							<a href="#" class="btn btn-primary">Quay lại</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-2 col-12"></div>
	</div>
</body>
</html>