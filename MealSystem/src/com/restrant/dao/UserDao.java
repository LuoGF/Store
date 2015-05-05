package com.restrant.dao;

import java.util.List;

import com.restrant.entity.Admin;
import com.restrant.entity.User;

public interface UserDao {
public List search(User condition);
public List search(Admin condition);
}
