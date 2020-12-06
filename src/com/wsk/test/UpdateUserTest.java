package com.wsk.test;

import com.wsk.pojo.Users;
import com.wsk.service.UsersService;
import com.wsk.service.impl.UsersServiceimpl;

public class UpdateUserTest {
    public static void main(String[] args) {
        UsersService usersService = new UsersServiceimpl();
        Users users = usersService.preUpdateUsers(3);
        System.out.println(users.getUserid());
        users.setUsername("Ole");
        users.setUsersex("MALE");
        usersService.modifyUser(users);
    }


}
