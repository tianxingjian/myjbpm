<%@ page contentType="text/html; charset=GBK" %> 
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>�ļ��ϴ�</title>
</head>
<body>

</body>
	<form name="fm" action="${ctx }/deploy/deploy.action" method = "post" enctype="multipart/form-data">
	<div id="wrapper">
		<div id="container">
			<div id="crash_menu">
				<h2 align="center">
					�����ļ����루.xml/.zip��
				</h2>
			</div>
			<table class="fix_table">
				<tr>
					<td class="bgc_tt short">
						ѡ���ļ���
					</td>
					<td class="long">
						<input type = "file" name = "deployFile">
					</td>
				<tr>
					<td colspan="6" align="center">
						<input type="submit" class="button_ty" value="��ʼ�ϴ�">
					</td>
				</tr>
			</table>
		</div>
		<div id="content_navigation"  class="query"></div>
		<div id="content" class="sort"></div>
	</div>
</form>
</html>