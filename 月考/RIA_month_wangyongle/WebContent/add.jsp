<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css.css">
<script type="text/javascript" src="jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	$(function() {
/* 		var st = /{2,}/;
		$(".name").blur(function() {
			if (this.val().test(st)) {
				this.prop("<span style='color:#f00'>输入合法</sqpan>");
				
			} else {

				this.prop("<span style='color:red'>输入非法</sqpan>");
			}
		}) */
		$(".but").click(function() {
		var str = $("form").serialize();
			$.ajax({
				type:"post",
				url:"doctorServlet?method=add",
				data:str,
				success:function(data){
					if (null != data) {
						alert("添加成功");
						location.href="doctorServlet?method=showAll";
					}
				}
			});
			
		});
	});
</script>
</head>
<body>
<h1>数据新增页</h1>
	<form>
		<table>
			<tr>
				<td>医生姓名：</td>
				<td><input type="text" class="name" name="name"></td>
			</tr>
			<tr>
				<td>医生性别：</td>
				<td>
					<input type="radio" class="gender" name="gender" value="男">男
					<input type="radio" class="gender" name="gender" value="女">女
				</td>
			</tr>
			<tr>
				<td>医生爱好：</td>
				<td>
					<input type="checkbox" class="hobby" name="hobby" value="跑步">跑步
					<input type="checkbox" class="hobby" name="hobby" value="爬山">爬山
					<input type="checkbox" class="hobby" name="hobby" value="足球">足球
					<input type="checkbox" class="hobby" name="hobby" value="太极">太极
					<input type="checkbox" class="hobby" name="hobby" value="其他">其他
				</td>
			</tr>
			<tr>
				<td>出生日期：</td>
				<td><input type="date" class="date" name="birth"></td>
			</tr>
			<tr>
				<td>所在科室：</td>
				<td>
					<select class="deptName" name="deptName">
						<option value="内科">内科</option>
						<option value="外科">外科</option>
						<option value="妇科">妇科</option>
						<option value="呼吸科">呼吸科</option>
						<option value="口腔科">口腔科</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="3"><input type="button" class="but" value="添加"></td>
			</tr>
		</table>
	</form>
</body>
</html>