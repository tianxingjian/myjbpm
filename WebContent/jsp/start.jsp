<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,org.jbpm.api.*,org.jbpm.api.task.*" %>
<%
	String id = request.getParameter("id");
	String userName = (String)session.getAttribute("userName");
	
	ProcessEngine processEngine = Configuration.getProcessEngine(); // 创建流程引擎
	ExecutionService executionService = processEngine.getExecutionService(); // 
	
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("owner", userName);
	executionService.startProcessInstanceById(id, map);
	
	response.sendRedirect("index.jsp");
%>