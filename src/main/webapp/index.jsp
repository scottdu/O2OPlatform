<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	String contextPath = request.getContextPath();
%>
<title></title>
</head>
<body>

<table align="center">
	<tr>
		<td>
			<ul style="list-style: none;">
				<li>
					<a href="<%=contextPath%>/user/regist">注册</a>(用户注册完毕默认是Customer)
				</li>
				<li>
					<a href="<%=contextPath%>/user/login">登陆</a>
				</li>
				<li>
					<a href="<%=contextPath%>/user/upload_auth">上传资料</a>(用户上传个人信息后为Service Provider)
				</li>
			</ul>
		</td>
	</tr>
</table>

</body>
</html>
