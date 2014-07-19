<%@ page contentType="text/html; charset=GBK" %>
<%@page import="java.util.Date"%> 
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="Stylesheet" type="text/css" href="style.css" />
</head>
<body>
	<div>
		当前登录用户"${username }"|
		<a href="${ctx }/deploy/preDeploy.action">发布新流程</a>|<a href="login.jsp">登录</a>
	</div>
	<div>
		<h2>流程列表</h2>
		<table>
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Version</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${list}" var="pd">
			<tr>
				<td>${pd.id }</td>
				<td>${pd.name }</td>
				<td>${pd.version }</td>
				<td></td>
				<td>
					<a href="remove.jsp?deploymentId='${pd.deploymentId }'">删除</a>|
					<a href="${ctx }/flow/start.action?definityId=${pd.id }">启动流程</a>
					<a href="${ctx }/jsp/deploy/workFlowView.jsp?deployId=${pd.deploymentId }">查看流程</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		
		<h2>实例列表</h2>
		<table>
			<tr>
				<td>ID</td>
				<td>活动</td>
				<td>状态</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${piList }" var="pi">
			<tr>
				<td>${pi.id }</td>
				<td>${pi.name }</td>
				<td>${pi.state }</td>
				<td><a href="${ctx }/flow/view.action?instanceId=${pi.id }">流程跟踪</a></td>
			</tr>
			</c:forEach>
		</table>
		
			<h2>任务列表</h2>
		<table>
			<tr>
				<td>ID</td>
				<td>名称</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${taskList }" var="task">
			<tr>
				<td>${task.id }</td>
				<td>${task.name }</td>
				<td><a href="dfdf?taskId='${task.id }'">查看</a><br /></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>