package cn.com.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;

import org.jbpm.api.ProcessEngine;
import org.jbpm.api.RepositoryService;
import org.jbpm.test.AbstractTransactionalSpringJbpmTestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/applicationContext-hibernate.xml",
		"classpath:spring/applicationContext-jbpm.xml" })
public class JbpmTest extends AbstractTransactionalSpringJbpmTestCase{
	
	@Resource
	protected ProcessEngine processEngine; 
	//@Test
	public void testJbpm() {
		RepositoryService repositoryService = processEngine.getRepositoryService();
		String deploymentId = repositoryService.createDeployment()
		        .addResourceFromClasspath("cn/com/test/process.jpdl.xml")
		        .deploy();
		System.out.println(deploymentId);
	}

	@Test
	public void testPng() throws IOException{
		RepositoryService repositoryService = processEngine.getRepositoryService();
		InputStream inputStream = repositoryService.getResourceAsStream(
				"90001", "leave.png");
		byte[] b = new byte[1024];
		int len = -1;
		
		while ((len = inputStream.read(b, 0, 1024)) != -1) {
			System.out.write(b, 0, len);
		}
	}
}
