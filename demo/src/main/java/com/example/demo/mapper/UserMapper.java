package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    int insert(User user);
    User getUserByNameAndpwd(@Param("userName") String userName,@Param("passWord") String passWord);
    User getUserByName(@Param("userName") String userName);
}
