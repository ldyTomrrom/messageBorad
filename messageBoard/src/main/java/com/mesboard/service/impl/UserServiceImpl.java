package com.mesboard.service.impl;

import com.mesboard.mapper.UserMapper;
import com.mesboard.model.User;
import com.mesboard.service.UserService;
import com.mesboard.utils.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 自出洞来无敌手 --
 * 2022/6/27
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public User userLogin(String at, String pwd) {
//        更新上次登录时间
        User user = userMapper.userLogin(at, pwd);
        if (user != null) {
            user.setLastLoginTime(DateUtils.formatDateTime(new Date()));
            userMapper.updateByPrimaryKeySelective(user);
        }

        return user;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertUser(User user) {

        return userMapper.insertSelective(user);
    }

    @Override
    public User checkPhone(String at) {
        return userMapper.checkPhone(at);
    }
}
