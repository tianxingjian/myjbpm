<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,org.jbpm.api.*,org.jbpm.api.model.*"%>
<%
	String id = request.getParameter("id"); // 获取流程实例ID
	ProcessEngine processEngine = Configuration.getProcessEngine();
	RepositoryService repositoryService = processEngine
			.getRepositoryService();
	ExecutionService executionService = processEngine
			.getExecutionService();
	ProcessInstance processInstance = executionService
			.findProcessInstanceById(id); // 根据ID获取流程实例
	Set<String> activityNames = processInstance
			.findActiveActivityNames(); // 获取实例执行到的当前节点的名称

	ActivityCoordinates ac = repositoryService.getActivityCoordinates(
			processInstance.getProcessDefinitionId(), activityNames
					.iterator().next());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View</title>
<link rel="Stylesheet" type="text/css" href="style.css" />
</head>
<body>
	<h2>流程图显示</h2>
	<img src="pic.jsp?id=<%=id%>"
		style="position: absolute; left: 0px; top: 0px" />
	<div
		style="position:absolute;border:2px solid red;left:<%=ac.getX()%>px;top:<%=ac.getY()%>px;width:<%=ac.getWidth()%>px;height:<%=ac.getHeight()%>px;"></div>
</body>
</html>