<%@page import="com.myclass.entity.CategoryEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/tablib.jsp"%>
<%
List<CategoryEntity> categories = (List<CategoryEntity>) request.getAttribute("categories");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách thể loại</title>
</head>
<body>
	<!-- Begin Page Content -->
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Danh sách thể loại bài viết</h4>
		</div>
		<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
			<a href="<c:url value ="/admin/category/add"/>"
				class="btn btn-sm btn-success">Thêm mới</a>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<div class="row">
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">STT</th>
						<th scope="col">Thể Loại</th>
						<th scope="col">Mã Thể Loại</th>

						<th scope="col">#</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (CategoryEntity categoryEntity : categories) {
					%>
					<tr>
						<th><%=categoryEntity.getId()%></th>
						<td><%=categoryEntity.getName()%></td>
						<td><%=categoryEntity.getCode()%></td>

						<td><a
							href='<%=request.getContextPath()%>/admin/category/edit?id=<%=categoryEntity.getId()%>'
							class="btn btn-sm btn-primary">Sửa</a> <a
							href="<%=request.getContextPath()%>/admin/category/delete?id=<%=categoryEntity.getId()%>"
							class="btn btn-sm btn-danger">Xóa</a></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>

		</div>
	</div>

	<!-- /.container-fluid -->

</body>
</html>