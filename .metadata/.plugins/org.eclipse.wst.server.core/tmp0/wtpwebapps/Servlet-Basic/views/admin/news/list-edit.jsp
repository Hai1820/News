<%@page import="com.myclass.constant.UrlConstants"%>
<%@page import="com.myclass.entity.NewEntity"%>
<%@page import="java.util.List"%>
<%@page import="com.myclass.entity.CategoryEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<CategoryEntity> categories = (List<CategoryEntity>) request.getAttribute("categories");
NewEntity newEntity = (NewEntity) request.getAttribute("news");
%>
<%@include file="/common/tablib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa bài viết</title>
</head>
<body>

	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Edit News</h4>
		</div>
	</div>
	<!-- /.row -->
	<!-- .row -->
	<div class="row">
		<div class="col-md-2 col-12"></div>
		<div class="col-md-8 col-xs-12">
			<div class="white-box">
				<form method="post"
					action="<%=request.getContextPath() + "/admin/news/edit"%>"
					class="form-horizontal form-material">
					<input type="hidden" name="id" value="<%=newEntity.getId()%>"
						class="form-control form-control-line">
					<div class="form-group">
						<label class="col-md-12">Title</label>
						<div class="col-md-12">
							<input value="<%=newEntity.getTitle()%>" name="title" type="text"
								placeholder="Title" class="form-control form-control-line">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Short Description</label>
						<div class="col-md-12">
							<input value="<%=newEntity.getShortDescription()%>"
								name="Short Description" type="text" placeholder="Description"
								class="form-control form-control-line">
						</div>
					</div>
					<div class="input-group">
						<label class="col-md-12">Content</label>
						<div class="col-md-12">
							<textarea class="form-control" aria-label="With textarea"
								name="content" value="<%=newEntity.getContent()%>"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Thumb nail</label>
						<div class="col-md-12">
							<input type="file" name="thumbnail"
								value="<%=newEntity.getThumbnail()%>" class="form-control"
								id="customFile" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-12">Select Category</label>
						<div class="col-sm-12">
							<select name="categoryId" class="form-control form-control-line">
								<%
								for (CategoryEntity categoryEntity : categories) {
									String selected = newEntity.getCategoryId() == categoryEntity.getId() ? "selected" : "";
								%>
								<option value="<%=categoryEntity.getId()%>" <%=selected%>><%=categoryEntity.getName()%></option>
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