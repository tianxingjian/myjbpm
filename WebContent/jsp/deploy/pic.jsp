<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String id = request.getParameter("id");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>�鿴������ʽ</title>
<body>
	<div><h2>����ͼ��ʾ</h2></div>
	<div>
	<img src="${ctx }/deploy/view.action?deployId=<%=id %>"
		style="position: absolute; left: 10px; top: 40px" />
	</div>
</body>

</html>