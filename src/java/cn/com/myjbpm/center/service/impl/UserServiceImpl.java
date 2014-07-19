package cn.com.myjbpm.center.service.impl;

import java.util.List;

import cn.com.myjbpm.center.dao.impl.GenericDaoHibernate;
import cn.com.myjbpm.center.model.Ywuser;
import cn.com.myjbpm.center.service.UserService;

public class UserServiceImpl extends GenericDaoHibernate implements
		UserService {
	
	public UserServiceImpl() {
		super(Ywuser.class);
	}
	
	@Override
	public List<Ywuser> findUser() {
		List<Ywuser> list = super.queryAll();
		return list;
	}

	@Override
	public void save(Ywuser user) {
		super.insert(user);
	}
}
