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

	//用于封装登陆用户的类型，是哪个用户登陆
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
				//将用户存入session中
				session.put("user", list.get(0));
			}
		}
		if("adminlogin".equals(type)){
			User condition=new User();
			condition.setLoginName(user.getLoginName());
			condition.setLoginPwd(user.getLoginPwd());
			list=userBiz.login(condition);
			if(list.size()>0){
				//将用户存入session中
				session.put("admin", list.get(0));
			}
		}
		//转到名为toMealAction的action中
		return "toMealAction";
	}

}
