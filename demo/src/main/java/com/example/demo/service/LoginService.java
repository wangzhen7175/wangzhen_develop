package com.example.demo.service;

import com.example.demo.entity.User;

public interface LoginService {

    String login(String userId,String passWord);

    /**
     * 新用户注册
     * @param user
     * @return
     */
    String register(User user);

    User getUserById(String id);

    User getUserByIdAndName(String id,String userName);


}
