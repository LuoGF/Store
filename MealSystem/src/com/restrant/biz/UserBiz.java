package com.restrant.biz;

import java.util.List;

import com.restrant.entity.Admin;
import com.restrant.entity.User;

public interface UserBiz {
public List login(User condition); //�û���½��֤
public List login(Admin condition);//����Ա��½��֤

}
