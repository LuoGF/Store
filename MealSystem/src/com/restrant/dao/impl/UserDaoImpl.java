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
	//��ȡ��ϵ�б�
	SessionFactory sessionFactory;
	//�û���¼��֤
	public List search(User condition) {
	// TODO Auto-generated method stub
		List list=null;
		Session session=sessionFactory.getCurrentSession();
		 //����criteria����
		Criteria c=session.createCriteria(User.class);
		//ʹ��Exmple�����ഴ��ʵ������
		Example example=Example.create(condition);
		//ΪCriteria����ָ��ʾ������example��Ϊ��ѯ����
		c.add(example);
		list=c.list();//ִ�в�ѯ����ý��
		return list;
	}

	public List search(Admin condition) {
		// TODO Auto-generated method stub
		List list=null;
		Session session=sessionFactory.getCurrentSession();
		 //����criteria����
		Criteria c=session.createCriteria(Admin.class);
		//ʹ��Exmple�����ഴ��ʵ������
		Example example=Example.create(condition);
		//ΪCriteria����ָ��ʾ������example��Ϊ��ѯ����
		c.add(example);
		list=c.list();//ִ�в�ѯ����ý��
		return list;
		
	}

}
