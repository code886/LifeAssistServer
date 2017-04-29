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
	<center><h1>注册界面</h1></center>
	<form id="form" name="form" action="${basePath }/user/user_register.action" method="post" enctype="multipart/form-data">
    <table id="baseInfo" align="center" border="1" cellpadding="0" cellspacing="0"  >
        <tr>
            <td >头像：</td>
            <td>
                <input type="file" name="headImg"/>
            </td>
        </tr>
        <tr>
            <td >用户名：</td>
            <td><s:textfield name="user.name"/> </td>
        </tr>
        <tr>
            <td >帐号：</td>
            <td><s:textfield name="user.account"/></td>
        </tr>
        <tr>
            <td >密码：</td>
            <td><s:textfield name="user.password"/></td>
        </tr>
        <tr>
            <td >性别：</td>
            <td><s:radio list="#{'true':'男','false':'女'}" name="user.gender"/></td>
        </tr>
    </table>
       <center> <input type="submit" value="注册" /></center>
	</form>
</body>
</html>