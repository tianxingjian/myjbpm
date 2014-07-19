<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,org.jbpm.api.*,org.jbpm.api.task.*" %>
<%
	ProcessEngine processEngine = Configuration.getProcessEngine();
	TaskService taskService = processEngine.getTaskService();
	String taskId = request.getParameter("taskId");
	Task task = taskService.getTask(taskId); // 获取任务
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manager</title>
<link rel="Stylesheet" type="text/css" href="style.css" />
</head>
<body>
	<h2>经理审核</h2>
	<form action="submit_manager.jsp" method="post">
		<input type="hidden" name="taskId" value="${param.taskId }" />
		<table>
			<tr>
				<td>申请人</td>
				<td><%=taskService.getVariable(taskId, "owner") %></td>
			</tr>
			<tr>
				<td>请假时间（天）</td>
				<td><%=taskService.getVariable(taskId, "day") %></td>
			</tr>
			<tr>
				<td>请假原因</td>
				<td><%=taskService.getVariable(taskId, "reason") %></td>
			</tr>
		</table>
		<input type="submit" name="result" value="批准" />
		<input type="submit" name="result" value="驳回" />
	</form>
</body>
</html>