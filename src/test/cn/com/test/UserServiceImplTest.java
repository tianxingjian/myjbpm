package cn.com.test;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.com.myjbpm.center.model.Ywuser;
import cn.com.myjbpm.center.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/applicationContext-hibernate.xml",
		"classpath:spring/applicationContext-serviceContext.xml" })

public class UserServiceImplTest {
	@Resource
	private UserService userService;
	@Test
	public void testFindUser() {
		List<Ywuser> list = userService.findUser();
		for(Ywuser user : list){
			System.out.println(user.getUsername());
		}
	}

	@Test
	public void testSave(){
		Ywuser user = new Ywuser();
		user.setUsername("zheng");
		user.setPassword("1111");
		user.setCreatetime(new Date());
		userService.save(user);
	}
}
