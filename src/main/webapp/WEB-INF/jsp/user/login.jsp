<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
String contextPath = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%=contextPath%>/resources/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.css">
<title>登陆</title>
<script type="text/javascript">
var contextPath = "<%=contextPath%>";
</script>
<script type="text/javascript" src="<%=contextPath%>/resources/jquery/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/o2o/js/user/login.js"></script>
</head>
<body>
<div data-role="page">
	<div data-role="header">
		<h1>登陆页面</h1>
	</div>
	<div role="main" class="ui-content">
		<label for="username">用户名:</label>
        <input type="text" data-clear-btn="true" name="username" id="username" value="">

		<label for="password">密码:</label>
		<input type="password" data-clear-btn="true" name="password" id="password" value="" autocomplete="off">
		
		<fieldset class="ui-grid-a">
			<div class="ui-block-a"><button name="regist_btn" id="regist_btn">注册</button></div>
			<div class="ui-block-b"><button name="submit_btn" style="width:95%;" id="submit_btn" data-textonly="false" data-textvisible="true" data-msgtext="登陆中..." data-inline="true">登陆</button></div>
		</fieldset>
		
	</div>
	<div data-role="footer">
		<h4>版权</h4>
	</div>
</div>

	
</body>
</html>