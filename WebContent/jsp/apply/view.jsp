<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>�鿴������ʽ</title>
<body>
	<h2>����ͼ��ʾ</h2>
	
	<img src="${ctx }/deploy/view.action?deployId=${deployId }"
		style="position: absolute; left: 10px; top: 40px" />
		 
	<div
		style="position:absolute;border:2px solid red;left:${intX + 10 }px;top:${intY + 10 }px;width:${width }px;height:${height }px;"></div>
</body>

</html>