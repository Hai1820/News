<%@page import="java.util.List"%>
<%@page import="com.myclass.entity.CategoryEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/tablib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm mới bài viết</title>
<%
List<CategoryEntity> categories = (List<CategoryEntity>) request.getAttribute("categories");
%>
</head>
<body>
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Add News</h4>
		</div>
	</div>
	<!-- /.row -->
	<!-- .row -->
	<div class="row">
		<div class="col-md-2 col-12"></div>
		<div class="col-md-8 col-xs-12">
			<div class="white-box">
				<form method="post"
					action="<%=request.getContextPath() + "/admin/news/add"%>"
					class="form-horizontal form-material">
					<input type="hidden" name="id" value=""
						class="form-control form-control-line">
					<div class="form-group">
						<label class="col-md-12">Title</label>
						<div class="col-md-12">
							<input value="" name="title" type="text" placeholder="Title"
								class="form-control form-control-line">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Short Description</label>
						<div class="col-md-12">
							<input value="" name="shortdescription" type="text"
								placeholder="Description" class="form-control form-control-line">
						</div>
					</div>
					<div class="input-group">
						<label class="col-md-12">Content</label>
						<div class="col-md-12">
							<textarea class="form-control" aria-label="With textarea"
								name="shortdescription"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Thumb nail</label>
						<div class="col-md-12">
							<input type="file" class="form-control" id="customFile"
								name="thumbnail" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-12">Select Category</label>
						<div class="col-sm-12">
							<select name="categoryId" class="form-control form-control-line">
								<%
								for (CategoryEntity categoryEntity : categories) {
								%>
								<option value="<%=categoryEntity.getId()%>"><%=categoryEntity.getName()%></option>
								<%
								}
								%>

							</select>
						</div>

					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<button type="submit" class="btn btn-success">Save News</button>
							<a href='<c:url value = "/admin/news/list"/>'
								class="btn btn-primary">Back</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-2 col-12"></div>
	</div>
</body>
</html>