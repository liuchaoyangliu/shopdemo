package com.lcy.web.server;

import com.lcy.web.entity.User;

import java.util.LinkedList;

public interface UserService {

    LinkedList getUser();

    User getUserOne(String name);
}
