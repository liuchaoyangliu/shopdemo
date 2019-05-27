package com.lcy.web.server.impl;

import com.lcy.web.entity.User;
import com.lcy.web.jdbcServer.UserJdbc;
import com.lcy.web.server.UserService;

import java.util.LinkedList;

public class UserServiceImpl implements UserService {

    UserJdbc user = UserJdbc.getUserJdbc();

    @Override
    public LinkedList getUser() {

        LinkedList<User> link = user.getUser();
        return link;
    }

    @Override
    public User getUserOne(String name) {
        return null;
    }


}
