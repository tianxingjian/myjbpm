<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Request</title>
<link rel="Stylesheet" type="text/css" href="style.css" />
</head>
<body>
	<h2>申请</h2>
	<form action="submit.jsp" method="post">
		<input type="hidden" name="taskId" value="${param.taskId }" />
		<table>
			<tr>
				<td>申请人</td>
				<td><input type="text" name="owner" value="${sessionScope['user'] }"/></td>
			</tr>
			<tr>
				<td>请假时间（天）</td>
				<td><input type="text" name="day" value="" /></td>
			</tr>
			<tr>
				<td>请假原因</td>
				<td><input type="text" name="reason" value="" /></td>
			</tr>
		</table>
		<input type="submit" value="提交" />
	</form>
</body>
</html>