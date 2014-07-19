<%@ page contentType="text/html; charset=GBK" %> 
<%@ include file="/common/taglibs.jsp"%>
<%
	String id = request.getParameter("deployId");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>查看流程样式</title>
</head>
<frameset rows="46,*" frameborder="NO" border="0" framespacing="0"
	id="mainFrame">
	<frame src="${ctx}/jsp/deploy/deployTitle.jsp?id=<%=id %>" name="topFrame" scrolling="NO" noresize>
		<frame src="${ctx}/jsp/deploy/pic.jsp?id=<%=id %>" name="page" scrolling="auto"
			id="frainner" width="100%" height="100%" />
</frameset>
<body>
	<noframes>您的浏览器不支持框架!
	</noframes>
</body>
</html>