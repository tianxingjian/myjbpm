<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,org.jbpm.api.*,org.jbpm.api.task.*" %>
<%
	ProcessEngine processEngine = Configuration.getProcessEngine();
	TaskService taskService = processEngine.getTaskService();

	// 接收任务ID
	String taskId = request.getParameter("taskId");
	
	// 执行任务
	taskService.completeTask(taskId);
	
	// 跳转到首页
	response.sendRedirect("index.jsp");
%>