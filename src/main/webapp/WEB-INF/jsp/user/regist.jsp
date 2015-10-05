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
<title>注册</title>
<script type="text/javascript">
var contextPath = "<%=contextPath%>";
</script>
<script type="text/javascript" src="<%=contextPath%>/resources/jquery/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/o2o/js/user/regist.js?0.1"></script>
</head>
<body>

<div data-role="page">
	<div data-role="header">
		<h1>注册页面</h1>
	</div>
	<div role="main" class="ui-content">
		<table align="center">
		
		<label for="username">用户名</label>
        <input type="text" data-clear-btn="true" name="username" id="username" value="">
		
		<label for="password">密码</label>
		<input type="password" data-clear-btn="true" name="password" id="password" value="" autocomplete="off">
		
		<label for="repassword">再次输入密码</label>
		<input type="password" data-clear-btn="true" name="re_password" id="re_password" value="" autocomplete="off">
		
		<label for="gender">性别</label>
		<select name="gender" id="gender">
			<option value="UNKONWN" selected="selected">保密</option>
			<option value="MALE">男</option>
			<option value="FEMALE">女</option>
		</select>
		
		<label for="email">电子邮件</label>
		<input type="text" name="email" id="email" data-clear-btn="true" value=""/>
		
		<label for="mobile">手机</label>
		<input type="text" name="mobile" id="mobile" data-clear-btn="true" value=""/>
		
		<label for="user_type">用户类型</label>
		<select name="user_type" id="user_type">
			<option value="PERSONAL" selected="selected">个人</option>
			<option value="ORGANIZATION">公司</option>
		</select>
		
		<label for="fix_phone_no">固定电话</label>
		<input type="text" name="fix_phone_no" id="fix_phone_no" data-clear-btn="true" value=""/>
		
		
		<label for="country">国家</label>
		<select name="country" id="country">
			<option value="CHINA" selected="selected">中国</option>
		</select>
		
		<label for="province">省份</label>
		<select name="province" id="province">
			<option value="P_BEIJING" selected="selected">北京市</option>
			<option value="P_SHANGHAI">上海市</option>
			<option value="P_SHANGHAI">浙江省</option>
		</select>
		
		
		<label for="city">城市</label>
		<select name="city" id="city">
			<option value="C_BEIJING" selected="selected">北京</option>
			<option value="C_SHANGHAI">上海</option>
			<option value="C_SHANGHAI">杭州</option>
		</select>
		
		<label for="street">街道</label>
		<input type="text" name="street" id="street" data-clear-btn="true" value=""/>
			
		<label for="work_address">工作地点</label>
		<textarea name="work_address" id="work_address" rows="5" cols="30"></textarea>
			
		<button name="submit_btn" style="width:100%;" id="submit_btn" data-textonly="false" data-textvisible="true" data-msgtext="注册中..." data-inline="true">注册</button>
		
					
	</div>
	<div data-role="footer">
		<h4>版权</h4>
	</div>
</div>



</body>
</html>