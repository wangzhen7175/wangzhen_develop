package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.LoginMapper;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;
    @Override
    public String login(String userId, String passWord) {
        return null;
    }

    @Override
    public String register(User user) {

        int i = loginMapper.insert(user);
        String result = "注册成功";
       if(i == 0){
           result = "注册失败";
       }
        return result;
    }

    @Override
    public User getUserById(String id) {
        return loginMapper.getUserById(id);
    }

    @Override
    public User getUserByIdAndName(String id, String userName) {
        Map map = new HashMap();
        map.put("userId",id);
        map.put("userName",userName);
        return loginMapper.getUserByIdAndName(map);
    }
}
