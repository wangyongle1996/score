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
	var id2 =location.search;
	var id =id2.substring(1);
	$.ajax({
		type:"post",
		url:"doctorServlet?method=select",
		data:id,
		dataType:"json",
		success:function(data){
			$(".id").val(data.id);
			$(".name").val(data.name);
			$(".date").val(data.birth);
			$(".gender").each(function() {
				if (this.value == data.gender) {
					this.checked = true;
				} else {
					this.checked = false;
				}
			});
			var str = data.hobby.split(",");
			$(".hobby").each(function() {
				for ( var i in str) {
					if (str[i] == this.value) {
						this.checked = true;
					}
				}
			});
			$(".deptName").each(function() {
				if (data.deptName == this.value) {
					this.select = true;
				}
			})
			
		}
	});
	$(".but").click(function() {
		var str = $("form").serialize();
		if (confirm("您确定要修改编号为"+$(".id").value+"的医生信息吗？")) {
			
			$.ajax({
				type:"post",
				url:"doctorServlet?method=update",
				data:str,
				success:function(data){
					if (null != data) {
						alert("修改成功");
						location.href="doctorServlet?method=showAll";
					}
				}
			});
		}
			
		});
});
</script>
</head>
<body>
<h1>数据修改页</h1>
			<form>
			<input type="hidden" name="id" class="id">
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
				<td colspan="3"><input type="button" class="but" value="修改"></td>
			</tr>
		</table>
			</form>
</body>
</html>