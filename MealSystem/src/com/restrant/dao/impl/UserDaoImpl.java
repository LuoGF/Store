package com.restrant.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.restrant.dao.UserDao;
import com.restrant.entity.Admin;
import com.restrant.entity.User;

public class UserDaoImpl implements UserDao{
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//获取菜系列表
	SessionFactory sessionFactory;
	//用户登录验证
	public List search(User condition) {
	// TODO Auto-generated method stub
		List list=null;
		Session session=sessionFactory.getCurrentSession();
		 //创建criteria对象
		Criteria c=session.createCriteria(User.class);
		//使用Exmple工具类创建实例对象
		Example example=Example.create(condition);
		//为Criteria对象指定示例对象example作为查询条件
		c.add(example);
		list=c.list();//执行查询，获得结果
		return list;
	}

	public List search(Admin condition) {
		// TODO Auto-generated method stub
		List list=null;
		Session session=sessionFactory.getCurrentSession();
		 //创建criteria对象
		Criteria c=session.createCriteria(Admin.class);
		//使用Exmple工具类创建实例对象
		Example example=Example.create(condition);
		//为Criteria对象指定示例对象example作为查询条件
		c.add(example);
		list=c.list();//执行查询，获得结果
		return list;
		
	}

}
