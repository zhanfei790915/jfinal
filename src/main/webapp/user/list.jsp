<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户信息列表</title>
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="main" class="container">
		<div class="row" />
		<div class="col-lg-12 col-sm-12 col-md-12">
			<div class="pull-right">
				<a herf="" class="btn btn-primary">新增用户</a>
			</div>
			<table class="table table-hover table-bordered">
				<thead>
					<th>ID</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>备注</th>
					<th>操作</th>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>詹飞</td>
						<td>男</td>
						<td>37</td>
						<td>不知道</td>
						<td><a herf="" class="btn btn-primary btn-sm">修改</a><a
							herf="" class="btn btn-danger btn-sm">删除</a></td>
					</tr>
					<tr>
						<td>2</td>
						<td>刘玉</td>
						<td>女</td>
						<td>47</td>
						<td>不知道</td>
						<td><a herf="" class="btn btn-primary btn-sm">修改</a><a
							herf="" class="btn btn-danger btn-sm">删除</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>