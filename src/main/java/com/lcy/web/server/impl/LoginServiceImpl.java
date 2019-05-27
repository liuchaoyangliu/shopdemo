package com.lcy.web.server.impl;

import com.lcy.web.entity.User;
import com.lcy.web.jdbcServer.LoginJdbc;
import com.lcy.web.server.LoginService;

public class LoginServiceImpl implements LoginService {


    @Override
    public User login(String name, String password) {
        LoginJdbc loginJdbc = LoginJdbc.getLoginJdbc();
        User user = loginJdbc.getUser(name, password);
        if(user == null){
            return null;
        }else {
            return user;
        }
    }

}
