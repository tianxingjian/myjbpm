package cn.com.myjbpm.center.service;

import java.util.List;

import cn.com.myjbpm.center.model.Ywuser;

public interface UserService {
	public List<Ywuser> findUser();
	 
	public void save(Ywuser user);
}
