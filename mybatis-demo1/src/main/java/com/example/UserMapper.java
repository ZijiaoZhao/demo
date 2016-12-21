package com.example;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by zijiao on 12/15/16.
 */
//@Mapper
public interface UserMapper {
    @Select("select * from users where id=#{id}")
    User getUser(int id);
}
