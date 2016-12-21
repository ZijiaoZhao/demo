package com.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.annotation.MapperScan;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * Created by zijiao on 12/15/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String resource = "configuration.xml";
        InputStream reader = Main.class.getClassLoader().getResourceAsStream(resource);

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();

        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user = userMapper.getUser(1);
        System.out.println(user.getName());

        session.close();
    }

}
