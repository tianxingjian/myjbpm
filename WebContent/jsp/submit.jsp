<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,org.jbpm.api.*,org.jbpm.api.task.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	ProcessEngine processEngine = Configuration.getProcessEngine();
	TaskService taskService = processEngine.getTaskService();

	// 接收任务ID
	String taskId = request.getParameter("taskId");
	// 接收用户名
	String owner = request.getParameter("owner");
	// 接收请假天数
	int day = Integer.parseInt(request.getParameter("day"));
	// 接收请假原因
	String reason = request.getParameter("reason");
	
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("day", day);
	map.put("reason", reason);
	
	// 执行任务
	taskService.completeTask(taskId, map);
	
	// 跳转到首页
	response.sendRedirect("index.jsp");
%>