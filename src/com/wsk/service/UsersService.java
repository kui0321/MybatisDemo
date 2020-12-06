package com.wsk.service;

import com.wsk.pojo.Users;

public interface UsersService {
    void addUsers(Users users);
    Users preUpdateUsers(int userid);
    void modifyUser(Users users);
    void dropUserByid(int userid);
}
