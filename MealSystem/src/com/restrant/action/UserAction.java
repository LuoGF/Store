package com.restrant.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.restrant.biz.UserBiz;
import com.restrant.entity.User;

public class UserAction extends ActionSupport implements RequestAware,SessionAware{
	public UserBiz getUserBiz() {
		return userBiz;
	}

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	//���ڷ�װ��½�û������ͣ����ĸ��û���½
	private String type;
    UserBiz userBiz;
    private User user;
    Map<String, Object> request;
    Map<String, Object> session;
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	public String validateLogin()throws Exception{
		List list;
		if("userlogin".equals(type)){
			User condition=new User();
			condition.setLoginName(user.getLoginName());
			condition.setLoginPwd(user.getLoginPwd());
			list=userBiz.login(condition);
			if(list.size()>0){
				//���û�����session��
				session.put("user", list.get(0));
			}
		}
		if("adminlogin".equals(type)){
			User condition=new User();
			condition.setLoginName(user.getLoginName());
			condition.setLoginPwd(user.getLoginPwd());
			list=userBiz.login(condition);
			if(list.size()>0){
				//���û�����session��
				session.put("admin", list.get(0));
			}
		}
		//ת����ΪtoMealAction��action��
		return "toMealAction";
	}

}
