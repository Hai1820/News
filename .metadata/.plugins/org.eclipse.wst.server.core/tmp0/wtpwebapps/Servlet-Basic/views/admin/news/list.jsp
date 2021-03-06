<%@page import="com.myclass.dto.NewsDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/tablib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách bài viết</title>
<!-- Custom link pagnition for this template-->

</head>
<body>
	<!-- Begin Page Content -->
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Danh sách tin tức</h4>
		</div>
		<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
			<a href="<c:url value ="/admin/news/add"/>"
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
						<th scope="col">Tên Bài</th>
						<th scope="col">Mô tả ngắn</th>
						<th scope="col">Thể loại</th>
						<th scope="col">#</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<NewsDto> newsList = (List<NewsDto>) request.getAttribute("news");
					%>
					<%
					for (NewsDto dto : newsList) {
					%>
					<tr>
						<th><%=dto.getId()%></th>
						<td><%=dto.getTitle()%></td>
						<td><%=dto.getShortDescription()%></td>
						<td><%=dto.getCategoryName()%></td>
						<td><a
							href='<%=request.getContextPath()%>/admin/news/edit?id=<%=dto.getId()%>'
							class="btn btn-sm btn-primary">Sửa</a> <a
							href="<%=request.getContextPath() %>/admin/news/delete?=<%=dto.getId() %>"
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