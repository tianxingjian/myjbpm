package cn.com.myjbpm.center.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskService;
import org.jbpm.api.task.Task;

import cn.com.myjbpm.center.model.Ywuser;
import cn.com.myjbpm.common.util.BaseAction;

public class LoginAction extends BaseAction {
	
	String username;
	String password;
	List<ProcessDefinition> list;
	List<ProcessInstance> piList;
	List<Task> taskList;
	@Resource
	ProcessEngine processEngine;
	/*处理登录*/
	public String login(){
	
		if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)){
			session.put("user", username);
			
			RepositoryService repositoryService = processEngine.getRepositoryService(); // 创建一个流程服务
			ExecutionService executionService = processEngine.getExecutionService(); // 实例服务
			TaskService taskService = processEngine.getTaskService(); // 任务
			
			list = repositoryService.createProcessDefinitionQuery().list(); // 获取流程列表
			piList = executionService.createProcessInstanceQuery().list(); // 获取实例列表
			taskList = taskService.findPersonalTasks(username);
			
			return SUCCESS;
		}else{
			return INPUT;
		}
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<ProcessDefinition> getList() {
		return list;
	}

	public void setList(List<ProcessDefinition> list) {
		this.list = list;
	}

	public List<ProcessInstance> getPiList() {
		return piList;
	}

	public void setPiList(List<ProcessInstance> piList) {
		this.piList = piList;
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}
	
}
