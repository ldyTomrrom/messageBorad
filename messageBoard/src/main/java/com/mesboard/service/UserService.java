package com.mesboard.service;

import com.mesboard.model.User;

/**
 * 自出洞来无敌手 --
 * 2022/6/27
 */
public interface UserService {
    User userLogin(String at, String pwd);

    int insertUser(User user);


    User checkPhone(String at);
}
