package com.chaijin.service.impl;

import com.chaijin.entity.User;
import com.chaijin.mapper.UserMapper;
import com.chaijin.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: SpringBoot2-Learning
 * @Package: com.chaijin.service
 * @ClassName: UserService
 * @Description:
 * @Author: 柴进
 * @Date: 2019/2/28 9:58
 * @Version: 1.0
 */
@Service(value = "UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String pageUser(User user) {
        PageHelper.startPage(user.getPageNum(),user.getPageSize());
        List<User> users = userMapper.selectAll();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return userPageInfo.toString();
    }
}
