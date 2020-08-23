package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface UserService {

    /**
     * 新用户注册
     * @param user
     * @return
     */
    Map register(User user, HttpSession session, Model model);

    Map UserLogin(User user, HttpSession session, Model model);

    void getUserRoles(HttpSession session, Model model);


}
