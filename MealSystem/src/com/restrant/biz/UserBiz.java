package com.restrant.biz;

import java.util.List;

import com.restrant.entity.Admin;
import com.restrant.entity.User;

public interface UserBiz {
public List login(User condition); //用户登陆验证
public List login(Admin condition);//管理员登陆验证

}
