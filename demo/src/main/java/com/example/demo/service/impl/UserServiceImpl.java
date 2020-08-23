package com.example.demo.service.impl;

import com.example.demo.constant.CommonConstant;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.GenerateIdService;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private GenerateIdService generateIdService;

    @Override
    public Map register(User user, HttpSession session, Model model) {
        Map<String, Object> map = new HashMap<>();

        if (user == null) {
            map.put("success", false);
            map.put("message", "注册失败");
            return map;
        }
        if (user.getUserName() == null || user.getPassword() == null) {
            map.put("success", false);
            map.put("message", "注册失败");
            return map;
        }
        //判断用户名是否重复
        User getUser = userMapper.getUserByName(user.getUserName());

        if (getUser == null) {
            user.setUserId(generateIdService.generateId("user"));
            user.setStatus("1");
            userMapper.insert(user);

            // 设置session
            session.setAttribute(CommonConstant.SESSION_KEY, user.getUserName());
            map.put("success", true);
            map.put("message", "注册成功");
            model.addAttribute("userName", user.getUserName());
            return map;
        } else {
            map.put("success", false);
            map.put("message", "注册失败");
            return map;
        }

    }

    @Override
    public Map UserLogin(User user, HttpSession session, Model model) {
        User getUser = userMapper.getUserByNameAndpwd(user.getUserName(), user.getPassword());
        Map<String, Object> map = new HashMap<>();
        if (getUser != null) {
            //用户名密码正确
            logger.info("用户登录成功" + user.getUserName());
            // 设置session
            session.setAttribute(CommonConstant.SESSION_KEY, user.getUserName());
            map.put("success", true);
            map.put("message", "登录成功");
            model.addAttribute("userName", user.getUserName());
            return map;
        } else {
            map.put("success", false);
            map.put("message", "登录失败");
            return map;
        }
    }

    @Override
    public void getUserRoles(HttpSession session, Model model) {

        String userName = session.getAttribute(CommonConstant.SESSION_KEY).toString();
        User user = userMapper.getUserByName(userName);
        model.addAttribute("userName", userName);
        List<Role> roleList = roleMapper.getRoleList(user.getRoleIds());
        if (roleList.size() == 0) {
            model.addAttribute("roleList", "无任何权限");
        } else {
            StringBuffer roleSb = new StringBuffer();
            for (Role role : roleList) {
                roleSb.append(role.toHtmlString());
            }
            model.addAttribute("roleList", roleSb.toString());
        }

    }

}
