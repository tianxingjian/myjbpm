<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,org.jbpm.api.*,org.jbpm.api.task.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	ProcessEngine processEngine = Configuration.getProcessEngine();
	TaskService taskService = processEngine.getTaskService();

	// 接收任务ID
	String taskId = request.getParameter("taskId");
	// 接受命令
	String result = request.getParameter("result");
	
	// 执行任务
	/*
	 * jbpm会根据传过去的result来判断流程转向哪个task
	 */
	taskService.completeTask(taskId, result);
	
	// 跳转到首页
	response.sendRedirect("index.jsp");
%>