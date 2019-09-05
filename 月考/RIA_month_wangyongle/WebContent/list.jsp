<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css.css">
<script type="text/javascript" src="jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".bu1").click(function() {
			$(":checkbox").prop(checked,true);
		});
		$(".bu2").click(function() {
			$(":checkbox").prop(checked,false);
		});
		$(".bu3").click(function() {
			$(":checkbox").each(function() {
				if (this.checked == true) {
					this.checked = false;
				} else {
					this.checked = true;
				}
			});
		});
		$(".bu5").click(function() {
				var id = "";
			$(":checkbox").each(function() {
				if (this.checked == true) {
					id += this.value + ",";
				}
			});
				
			if (confirm("您确定要删除编号为"+id+"的医生信息吗？")) {
				$.ajax({
					type:"post",
					url:"doctorServlet?method=deleteBatch",
					data:"id="+id,
					success:function(data){
						alert("删除成功")
						location.href = "doctorServlet?method=showAll";
					}
				});
			}
				
		});
	})
</script>
</head>
<body>
<h6>欢迎您<span style="color: red">${name }</span> ,来到医生信息管理系统</h6>
<table>
	<thead>
		<tr><th colspan="20">医生信息管理系统</th></tr>
		<tr>
			<td>请选择</td>
			<td>医生编号</td>
			<td>医生姓名</td>
			<td>性别</td>
			<td>出生日期</td>
			<td>爱好</td>
			<td>所在科室名称</td>
			<td>操作</td>
	</thead>
	<tbody>
		<c:forEach items="${li }" var="li">
			<tr>
				<td><input type="checkbox" value="${li.id }"></td>
				<td>${li.id }</td>
				<td>${li.name }</td>
				<td>${li.gender }</td>
				<td>${li.birth }</td>
				<td>${li.hobby }</td>
				<td>${li.deptName }</td>
				<td><a href="update.jsp?id=${li.id }"><input type="button" value="修改"></a></td>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr><td colspan="20"><input type="button" class="bu1" value="全选">
		<input type="button" class="bu2" value="全不选">
		<input type="button" class="bu3" value="反选">
		<a href="add.jsp"><input type="button" class="bu4" value="新增"></a>
		<input type="button" class="bu5" value="批量删除"></td></tr>
	</tfoot>
</table>
</body>
</html>