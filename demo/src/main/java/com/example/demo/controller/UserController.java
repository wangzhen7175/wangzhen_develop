package com.example.demo.controller;

import com.example.demo.constant.CommonConstant;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


/**
 * 登录，注册
 */
@Controller
@CrossOrigin
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    //进入登录页面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "Login";

    }
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updatePage() {
        return "Update";

    }
    //进入注册页面
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage() {
        return "Register";

    }
    //进入首页
    @RequestMapping("/index")
    public String index(HttpSession session, Model model) {

        userService.getUserRoles(session,model);
        return "index";
    }

    //登录
   @RequestMapping(value = "/login", method = RequestMethod.POST)
   @ResponseBody
   public  Map loginPost(User user, HttpSession session, Model model) {

       return userService.UserLogin(user,session,model);
   }

   //注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Map register(User user, HttpSession session, Model model) {
        logger.info("用户注册开始");
        return userService.register(user,session,model);

    }

    //登出/注销
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(CommonConstant.USER_NAME);
        session.removeAttribute(CommonConstant.USER_ID);
        return "redirect:/login";
    }

}
