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
		��ǰ��¼�û�"${username }"|
		<a href="${ctx }/deploy/preDeploy.action">����������</a>|<a href="login.jsp">��¼</a>
	</div>
	<div>
		<h2>�����б�</h2>
		<table>
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Version</td>
				<td>����</td>
			</tr>
			<c:forEach items="${list}" var="pd">
			<tr>
				<td>${pd.id }</td>
				<td>${pd.name }</td>
				<td>${pd.version }</td>
				<td></td>
				<td>
					<a href="remove.jsp?deploymentId='${pd.deploymentId }'">ɾ��</a>|
					<a href="${ctx }/flow/start.action?definityId=${pd.id }">��������</a>
					<a href="${ctx }/jsp/deploy/workFlowView.jsp?deployId=${pd.deploymentId }">�鿴����</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		
		<h2>ʵ���б�</h2>
		<table>
			<tr>
				<td>ID</td>
				<td>�</td>
				<td>״̬</td>
				<td>����</td>
			</tr>
			<c:forEach items="${piList }" var="pi">
			<tr>
				<td>${pi.id }</td>
				<td>${pi.name }</td>
				<td>${pi.state }</td>
				<td><a href="${ctx }/flow/view.action?instanceId=${pi.id }">���̸���</a></td>
			</tr>
			</c:forEach>
		</table>
		
			<h2>�����б�</h2>
		<table>
			<tr>
				<td>ID</td>
				<td>����</td>
				<td>����</td>
			</tr>
			<c:forEach items="${taskList }" var="task">
			<tr>
				<td>${task.id }</td>
				<td>${task.name }</td>
				<td><a href="dfdf?taskId='${task.id }'">�鿴</a><br /></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>