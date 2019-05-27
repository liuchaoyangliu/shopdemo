package com.lcy.web.server;

import com.lcy.web.entity.User;

public interface LoginService {

    User login(String name, String Password);

}
