package com.inspiry.service;

import com.inspiry.mapper.UserMapper;
import com.inspiry.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zijiao on 12/21/16.
 */
@Service
public class FooService {
    @Autowired
    private UserMapper userMapper;

    public void count() {
        System.out.println("user counts ------");
        System.out.println(userMapper.countByExample(null));
    }

    public void getUser(int id) {
        User user = userMapper.selectByPrimaryKey(id);

        if(user != null) {
            System.out.println("find user by id -------");
            System.out.println(user.getName());
        }
    }

    public void addUser(User user) {
        int row = userMapper.insert(user);
        System.out.println("insert a user --------");

        String msg = "FAIL";
        if(row > 0) {
            msg = "SUCCESS";
        }

        System.out.println(msg);
    }
}
