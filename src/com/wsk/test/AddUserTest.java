package com.wsk.test;

import com.wsk.pojo.Users;
import com.wsk.service.UsersService;
import com.wsk.service.impl.UsersServiceimpl;

public class AddUserTest {
    public static void main(String[] args) {
        UsersService usersService = new UsersServiceimpl();
        Users users = new Users();
        users.setUsername("LEFT");
        users.setUsersex("nice");

        usersService.addUsers(users);
    }
}
