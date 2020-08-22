package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;


/**
 * 登录，注册
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/login")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private User user;

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String login(@RequestParam  @Value("userName") @NonNull String userName,
                        @RequestParam  @Value("userId") @NonNull String userId){

        return loginService.getUserByIdAndName(userId,userName).toString();

    }
    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public String test2(@RequestParam  @Value("userId") @NonNull String userId){
        return loginService.getUserById(userId).toString();

    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        logger.info("用户注册开始");
        logger.debug("用户注册开始");
        logger.error("用户注册开始");
        logger.trace("用户注册开始");
        logger.warn("用户注册开始");
        user.setPassWord("wangzhen123");
        user.setStatus("1");
        user.setUserId("12345678");
        user.setUserName("王振");
       String result = loginService.register(user);
        return result;

    }
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        System.out.println("进来了");
        user.setPassWord("wangzhen123");
        user.setStatus("1");
        user.setUserId("123456");
        user.setUserName("王振");
        return user.toString();

    }


}
