<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm mới thể loại</title>
</head>
<body>
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Add Category</h4>
		</div>
	</div>
	<!-- /.row -->
	<!-- .row -->
	<div class="row">
		<div class="col-md-2 col-12"></div>
		<div class="col-md-8 col-xs-12">
			<div class="white-box">
				<form method="post"
					action="<%=request.getContextPath() + "/admin/category/add"%>"
					class="form-horizontal form-material">
					<input type="hidden" name="id" value=""
						class="form-control form-control-line">
					<div class="form-group">
						<label class="col-md-12">Tên thể loại</label>
						<div class="col-md-12">
							<input value="" name="name" type="text" placeholder="Name"
								class="form-control form-control-line">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Mã thể loại</label>
						<div class="col-md-12">
							<input value="" name="code" type="text" placeholder="Code"
								class="form-control form-control-line">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-12">
							<button type="submit" class="btn btn-success">Save</button>
							<a href='<c:url value = "/admin/category/list"/>'
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