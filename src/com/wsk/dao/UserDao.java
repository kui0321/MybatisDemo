package com.wsk.dao;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import com.wsk.pojo.Users;

import java.io.IOException;
import java.util.List;

public interface UserDao {
    List<Users> selectUsersAll() throws IOException;
    Users selectUsersById(int userid) throws IOException;
    void insertUsers(Users users) throws IOException;
    Users selectUsersById1(int userid) throws IOException;
    void UpdateUserById(Users users) throws IOException;
    void deleteUserById(int userid);
}
