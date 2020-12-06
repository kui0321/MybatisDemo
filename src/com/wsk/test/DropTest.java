package com.wsk.test;

import com.wsk.service.UsersService;
import com.wsk.service.impl.UsersServiceimpl;

public class DropTest {
    public static void main(String[] args) {
        UsersService usersService = new UsersServiceimpl();
        usersService.dropUserByid(3);
    }
}
