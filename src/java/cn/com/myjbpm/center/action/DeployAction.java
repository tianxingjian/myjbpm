package cn.com.myjbpm.center.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.RepositoryService;

import cn.com.myjbpm.common.util.BaseAction;
import cn.com.myjbpm.common.util.FileOperate;

public class DeployAction extends BaseAction {

	private static Log logger = LogFactory.getLog(DeployAction.class);
	
	/*��������*/
	@Resource
	ProcessEngine processEngine;
	/*�ļ�����*/
	private File deployFile;
	/*�ļ�����*/
	private String deployFileContentType;
	/*�ļ�����*/
	private String deployFileFileName;
	/*�������̱��*/
	private String deployId;

	public String preDeploy() {
		return SUCCESS;
	}

	public String deploy() throws Exception {
		logger.debug("�����ļ��ϴ�:" + this.deployFileFileName);
		if (!FileOperate.verifyFileClassy(this.deployFileFileName, "zip")) {
			return INPUT;
		}
		String target = ServletActionContext.getServletContext().getRealPath(
				"deployDir");
		FileOperate.examDir(target);
		File targetFile = new File(target + "/" + this.deployFileFileName);
		String jiexStr = target + "/" + this.deployFileFileName;
		FileOperate.copyFile(this.deployFile, targetFile);
		RepositoryService repositoryService = processEngine
				.getRepositoryService(); // ����һ�����̷���
		ZipInputStream zis = new ZipInputStream(new FileInputStream(deployFile));
		deployId = repositoryService.createDeployment().addResourcesFromZipInputStream(zis).deploy();
		logger.debug("�������̳ɹ��� " + deployId);
		return SUCCESS;
	}

	public void view() throws IOException{
		response.setCharacterEncoding("GBK");
	    response.setContentType("text/html");  
	    response.setHeader("Cache-Control", "no-store");  
	    response.setHeader("Pragma", "no-cache");  
	    response.setDateHeader("Expires", 0);  
	    RepositoryService repositoryService = processEngine
				.getRepositoryService(); // ����һ�����̷���
	    ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployId).uniqueResult();
	    System.out.println("######" + processDefinition.getName());
	    InputStream inputStream = repositoryService.getResourceAsStream(
				deployId, processDefinition.getName()+".png");
		
		byte[] b = new byte[1024];
		int len = -1;
		OutputStream ops = response.getOutputStream();
		while ((len = inputStream.read(b, 0, 1024)) != -1) {
			ops.write(b, 0, len);
		}
	}
	
	public File getDeployFile() {
		return deployFile;
	}

	public void setDeployFile(File deployFile) {
		this.deployFile = deployFile;
	}

	public String getDeployFileContentType() {
		return deployFileContentType;
	}

	public void setDeployFileContentType(String deployFileContentType) {
		this.deployFileContentType = deployFileContentType;
	}

	public String getDeployFileFileName() {
		return deployFileFileName;
	}

	public void setDeployFileFileName(String deployFileFileName) {
		this.deployFileFileName = deployFileFileName;
	}

	public String getDeployId() {
		return deployId;
	}

	public void setDeployId(String deployId) {
		this.deployId = deployId;
	}
	
}
