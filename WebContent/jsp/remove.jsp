<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,org.jbpm.api.*"%>
<%
	String deploymentId = request.getParameter("deploymentId");
	ProcessEngine processEngine = Configuration.getProcessEngine(); // 创建一个流程引擎
	RepositoryService repositoryService = processEngine
			.getRepositoryService(); // 创建一个流程服务

	repositoryService.deleteDeploymentCascade(deploymentId);

	response.sendRedirect("index.jsp");
%>