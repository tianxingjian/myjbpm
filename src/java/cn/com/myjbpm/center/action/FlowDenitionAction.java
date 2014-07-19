package cn.com.myjbpm.center.action;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.model.ActivityCoordinates;

import cn.com.myjbpm.common.util.BaseAction;

public class FlowDenitionAction extends BaseAction {
	/*��������*/
	@Resource
	ProcessEngine processEngine;
	
	String deployId;
	/*����id*/
	String definityId;
	
	/*����ʵ��id*/
	String instanceId;
	
	int intX;
	int intY;
	int width;
	int heigth;
	
	public String start(){
		String username = (String)this.session.get("user");
		if(StringUtils.isBlank(username)){
			return INPUT;
		}
		ExecutionService executionService = processEngine.getExecutionService(); // 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("owner", username);
		ProcessInstance instance = executionService.startProcessInstanceById(definityId, map);
		System.out.println("instance: " + instance.getId());
		return SUCCESS;
	}

	public String view(){
		RepositoryService repositoryService = processEngine
				.getRepositoryService();
		ExecutionService executionService = processEngine
				.getExecutionService();
		ProcessInstance processInstance = executionService
				.findProcessInstanceById(instanceId); // ����ID��ȡ����ʵ��
		Set<String> activityNames = processInstance
				.findActiveActivityNames(); // ��ȡʵ��ִ�е��ĵ�ǰ�ڵ������
		String processDefinitionId = processInstance
				.getProcessDefinitionId();
		ProcessDefinition processDefinition = repositoryService
				.createProcessDefinitionQuery()
				.processDefinitionId(processDefinitionId).uniqueResult();
		deployId = processDefinition.getDeploymentId();
		System.out.println("deployId: " + deployId);
		ActivityCoordinates ac = repositoryService.getActivityCoordinates(
				processInstance.getProcessDefinitionId(), activityNames
						.iterator().next());
		intX = ac.getX();
		intY = ac.getY();
		width = ac.getWidth();
		heigth = ac.getHeight();
		return SUCCESS;
	}
	public String getDefinityId() {
		return definityId;
	}

	public void setDefinityId(String definityId) {
		this.definityId = definityId;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public int getIntX() {
		return intX;
	}

	public void setIntX(int intX) {
		this.intX = intX;
	}

	public int getIntY() {
		return intY;
	}

	public void setIntY(int intY) {
		this.intY = intY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	public String getDeployId() {
		return deployId;
	}

	public void setDeployId(String deployId) {
		this.deployId = deployId;
	}
	
}
