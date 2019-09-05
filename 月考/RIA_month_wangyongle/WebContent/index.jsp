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
		$(":button").click(function() {
			var str = $("form").serialize();
			alert(str);
			$.ajax({
				type:"post",
				url:"userServlet?method=login",
				data:str,
				success:function(data){
					location.href="doctorServlet?method=showAll";
				}
			});
		});
	});
</script>
</head>
<body>
	<form>
		<table>
			<thead><tr><th colspan="5">登陆页</th></tr></thead>
			<tbody>
				<tr><td>用户名:<input type="text" name="userName"></td></tr>
				<tr><td>密&nbsp;&nbsp;&nbsp;码:<input type="password" name="userPwd"></td></tr>
				<tr><td><input type="button" value="登录"><input type="reset"></td></tr>
			</tbody>
		</table>
	</form>
</body>
</html>