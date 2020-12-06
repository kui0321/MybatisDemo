package com.wsk.test;

import com.wsk.dao.UserDao;
import com.wsk.dao.impl.UsersDaoImpl;
import com.wsk.pojo.Users;

import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        UserDao userDao = new UsersDaoImpl();
        List<Users> list = userDao.selectUsersAll();
        for (Users users: list) {
            System.out.println(users.getUserid()+"\t"+users.getUsername()+"\t"+users.getUsersex());
        }

        Users users1 = userDao.selectUsersById(1);
        System.out.println(users1.getUserid()+"\t"+users1.getUsername()+"\t"+users1.getUsersex());
    }
}
