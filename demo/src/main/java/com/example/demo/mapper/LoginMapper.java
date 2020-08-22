package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface LoginMapper {

    int insert(User user);
    User getUserById(String userId);
    User getUserByIdAndName(Map map);
    List<User> getUsersByGroupId(String groupId);
}
