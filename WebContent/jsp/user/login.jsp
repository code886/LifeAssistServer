<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <%@include file="/common/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center><h1>登录界面</h1></center>
	<form action="${basePath }/user/user_login.action" method="post" enctype="multipart/form-data">
		<table align="center" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>帐号</td>
				<td><s:textfield name="user.account"></s:textfield></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><s:textfield name="user.password"></s:textfield></td>
			</tr>
		</table>
		<center>
			<input type="submit" value="登录">
 			&nbsp;&nbsp;&nbsp;&nbsp;
 			<input type="button" value="注册" onclick="${basePath}/jsp/user/register.jsp">
		</center>
	</form>
</body>
</html>