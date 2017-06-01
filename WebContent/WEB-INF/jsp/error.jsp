<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<img src="<%=request.getContextPath()%>/images/common/error.jpg">
	<br/>
	<s:if test="exception.errorMsg!='' && exception.errorMsg!=null">
		<s:property value="exception.errorMsg"/>
	</s:if>
	<s:else>
		操作失败！<s:property value="exception.message"/>	
	</s:else>
</body>
</html>